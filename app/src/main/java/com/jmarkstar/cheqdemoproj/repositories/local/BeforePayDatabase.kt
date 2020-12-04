package com.jmarkstar.cheqdemoproj.repositories.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jmarkstar.cheqdemoproj.repositories.local.entities.Bank
import com.jmarkstar.cheqdemoproj.repositories.local.entities.BankAccount
import com.jmarkstar.cheqdemoproj.repositories.local.entities.SpendingCategory
import com.jmarkstar.cheqdemoproj.repositories.local.entities.Transaction
import com.jmarkstar.cheqdemoproj.repositories.local.daos.BankAccountDao
import com.jmarkstar.cheqdemoproj.repositories.local.daos.BankDao
import com.jmarkstar.cheqdemoproj.repositories.local.daos.SpendingCategoryDao
import com.jmarkstar.cheqdemoproj.repositories.local.daos.TransactionDao

@Database(entities = [
    Bank::class,
    BankAccount::class,
    SpendingCategory::class,
    Transaction::class
],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class BeforePayDatabase: RoomDatabase() {

    abstract val bankDao: BankDao
    abstract val bankAccountDao: BankAccountDao
    abstract val spendingCategoryDao: SpendingCategoryDao
    abstract val transactionDao: TransactionDao
}