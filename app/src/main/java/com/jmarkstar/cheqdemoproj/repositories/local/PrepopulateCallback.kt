package com.jmarkstar.cheqdemoproj.repositories.local

import android.database.sqlite.SQLiteDatabase
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jmarkstar.cheqdemoproj.models.TransactionType
import com.jmarkstar.cheqdemoproj.repositories.local.entities.Bank
import com.jmarkstar.cheqdemoproj.repositories.local.entities.BankAccount
import com.jmarkstar.cheqdemoproj.repositories.local.entities.SpendingCategory
import com.jmarkstar.cheqdemoproj.repositories.local.entities.Transaction
import timber.log.Timber
import java.util.*

class PrepopulateCallback : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        Timber.d("Population started")
        Timber.d("Populating spending_categories")
        db.insert(SPENDING_CATEGORY_TABLE, SQLiteDatabase.CONFLICT_REPLACE, SpendingCategory(1, "Groceries", "ic_grocery").toContentValues())
        db.insert(SPENDING_CATEGORY_TABLE, SQLiteDatabase.CONFLICT_REPLACE, SpendingCategory(2, "Restaurants", "ic_restaurant").toContentValues())
        db.insert(SPENDING_CATEGORY_TABLE, SQLiteDatabase.CONFLICT_REPLACE, SpendingCategory(3, "Household", "ic_household").toContentValues())

        Timber.d("Populating banks")
        db.insert(BANK_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Bank(1, "Westpac", "ic_westpac").toContentValues())
        db.insert(BANK_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Bank(2, "Commbank", "ic_commbank").toContentValues())

        Timber.d("Populating bank_accounts")
        db.insert(BANK_ACCOUNT_TABLE, SQLiteDatabase.CONFLICT_REPLACE, BankAccount(1, 1, "063-565 4564 7054", "Choice").toContentValues())
        db.insert(BANK_ACCOUNT_TABLE, SQLiteDatabase.CONFLICT_REPLACE, BankAccount(2, 1, "063-456 1223 3423", "Saving").toContentValues())
        db.insert(BANK_ACCOUNT_TABLE, SQLiteDatabase.CONFLICT_REPLACE, BankAccount(3, 2, "063-234 4534 5667", "Smart Access").toContentValues())
        db.insert(BANK_ACCOUNT_TABLE, SQLiteDatabase.CONFLICT_REPLACE, BankAccount(4, 2, "063-234 7889 4534", "NetBank Saver").toContentValues())

        Timber.d("Population Finished")
    }

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        Timber.d("Re-population of transactions started")

        Timber.d("transactions data was deleted")
        db.delete(TRANSACTION_TABLE, null, null)

        val calendarNow = Calendar.getInstance()
        val timeStampNow = calendarNow.time.time

        val timeStamp4HoursAgo = Calendar.getInstance().run {

            val currentHour = calendarNow.get(Calendar.HOUR_OF_DAY)
            if (currentHour > 4) {
                set(Calendar.MONTH, currentHour-4)
            }
            time.time
        }

        val timeStamp1DayAgo = Calendar.getInstance().run {

            val currentDay = calendarNow.get(Calendar.DAY_OF_MONTH)
            if (currentDay > 0) {
                set(Calendar.DAY_OF_MONTH, currentDay-1)
            }
            time.time
        }

        val timeStampOneMonthAgo = Calendar.getInstance().run {
            val currentMonth = calendarNow.get(Calendar.MONTH)
            if (currentMonth > 0) {
                set(Calendar.MONTH, currentMonth-1)
            }
            time.time
        }

        Timber.d("Populating transactions")
        //Westpac

        //this month
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.INCOMING, amount = 4300.30, timestamp = timeStampNow).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 420.90, timestamp = timeStampNow, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 280.50, timestamp = timeStamp1DayAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 520.00, timestamp = timeStamp4HoursAgo, spendingCategoryId = 3).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.INCOMING, amount = 500.00, timestamp = timeStamp1DayAgo).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 50.90, timestamp = timeStamp4HoursAgo, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 70.50, timestamp = timeStamp4HoursAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 90.00, timestamp = timeStamp1DayAgo, spendingCategoryId = 3).toContentValues())

        //one month ago
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.INCOMING, amount = 4000.40, timestamp = timeStampOneMonthAgo).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 345.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 450.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 1000.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.INCOMING, amount = 2000.30, timestamp = timeStampOneMonthAgo).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 100.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 200.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 800.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3).toContentValues())

        //CommBank

        //this month
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.INCOMING, amount = 4500.90, timestamp = timeStampNow).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 400.90, timestamp = timeStampNow, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 250.50, timestamp = timeStamp4HoursAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 560.00, timestamp = timeStamp1DayAgo, spendingCategoryId = 3).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.INCOMING, amount = 600.60, timestamp = timeStampNow).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 40.90, timestamp = timeStampNow, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 50.50, timestamp = timeStamp4HoursAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 60.00, timestamp = timeStamp1DayAgo, spendingCategoryId = 3).toContentValues())

        //one month ago
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.INCOMING, amount = 5000.20, timestamp = timeStampOneMonthAgo).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 845.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 670.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 1300.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.INCOMING, amount = 3000.10, timestamp = timeStampOneMonthAgo).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 200.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 400.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2).toContentValues())
        db.insert(TRANSACTION_TABLE, SQLiteDatabase.CONFLICT_REPLACE, Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 600.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3).toContentValues())

        Timber.d("Re-population of transactions finished")
    }

    companion object {

        private const val BANK_TABLE = "banks"
        private const val BANK_ACCOUNT_TABLE = "bank_accounts"
        private const val SPENDING_CATEGORY_TABLE = "spending_categories"
        private const val TRANSACTION_TABLE = "transactions"
    }
}