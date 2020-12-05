package com.jmarkstar.cheqdemoproj.di

import android.content.Context
import androidx.room.Room
import com.jmarkstar.cheqdemoproj.BuildConfig
import com.jmarkstar.cheqdemoproj.common.security.Passphrases
import com.jmarkstar.cheqdemoproj.repositories.BalanceRepository
import com.jmarkstar.cheqdemoproj.repositories.BalanceRepositoryImpl
import com.jmarkstar.cheqdemoproj.repositories.TransactionRepository
import com.jmarkstar.cheqdemoproj.repositories.TransactionRepositoryImpl
import com.jmarkstar.cheqdemoproj.repositories.local.BeforePayDatabase
import com.jmarkstar.cheqdemoproj.repositories.local.PrepopulateCallback
import com.jmarkstar.cheqdemoproj.repositories.sp.BeforePayPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
// https://dagger.dev/hilt/components.html
abstract class RepositoryModule {

    @Binds
    abstract fun bindsBalanceRepository(balanceRepositoryImpl: BalanceRepositoryImpl) : BalanceRepository

    @Binds
    abstract fun bindsTransactionRepository(transactionRepositoryImpl: TransactionRepositoryImpl) : TransactionRepository

    companion object {

        @Provides
        @Singleton
        fun provideDatabasePopulateCallback() = PrepopulateCallback()

        @Provides
        @Singleton
        fun provideSupportFactory(): SupportFactory? {
            val passphrase: ByteArray = SQLiteDatabase.getBytes(Passphrases.dbPassphrase.toCharArray())
            return if (BuildConfig.enableEncryption) SupportFactory(passphrase) else null
        }

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext appContext: Context,
                            prepopulateCallback: PrepopulateCallback,
                            supportFactory: SupportFactory? = null) =
                Room.databaseBuilder(appContext,
                        BeforePayDatabase::class.java,
                        "before_pay.db")
                        .openHelperFactory(supportFactory)
                        .addCallback(prepopulateCallback)
                        .build()

        @Provides
        @Singleton
        fun providePreferences(@ApplicationContext appContext: Context) = BeforePayPreferences(appContext)

        @Provides
        fun provideBankDao(database: BeforePayDatabase) = database.bankDao

        @Provides
        fun provideBankAccountDao(database: BeforePayDatabase) = database.bankAccountDao

        @Provides
        fun provideSpendingCategoryDao(database: BeforePayDatabase) = database.spendingCategoryDao

        @Provides
        fun provideTransactionDao(database: BeforePayDatabase) = database.transactionDao
    }
}
