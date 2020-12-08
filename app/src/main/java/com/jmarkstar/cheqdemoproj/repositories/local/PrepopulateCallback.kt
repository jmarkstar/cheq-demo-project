package com.jmarkstar.cheqdemoproj.repositories.local

import android.database.sqlite.SQLiteDatabase
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import timber.log.Timber

// Pre-populating data locally but obviously this data must come from an API.
class PrepopulateCallback : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        Timber.d("Population started")
        Timber.d("Populating spending_categories")

        fakeSpendingCategories.forEach {
            db.insert(SPENDING_CATEGORY_TABLE, SQLiteDatabase.CONFLICT_REPLACE, it.toContentValues())
        }

        Timber.d("Populating banks")
        fakeBanks.forEach {
            db.insert(BANK_TABLE, SQLiteDatabase.CONFLICT_REPLACE, it.toContentValues())
        }

        Timber.d("Populating bank_accounts")
        fakeBankAccounts.forEach {
            db.insert(BANK_ACCOUNT_TABLE, SQLiteDatabase.CONFLICT_REPLACE, it.toContentValues())
        }
        Timber.d("Population Finished")
    }

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        Timber.d("Re-population of transactions started")

        Timber.d("transactions data was deleted")
        db.delete(TRANSACTION_TABLE, null, null)

        fakeTransactions.forEach {
            db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, it.toContentValues())
        }
        Timber.d("Re-population of transactions finished")
    }

    companion object {

        private const val BANK_TABLE = "banks"
        private const val BANK_ACCOUNT_TABLE = "bank_accounts"
        private const val SPENDING_CATEGORY_TABLE = "spending_categories"
        private const val TRANSACTION_TABLE = "transactions"
    }
}