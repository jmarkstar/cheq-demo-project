package com.jmarkstar.cheqdemoproj.repositories.local

//This data is also used for unit test

import com.jmarkstar.cheqdemoproj.models.TransactionType
import com.jmarkstar.cheqdemoproj.repositories.local.entities.Bank
import com.jmarkstar.cheqdemoproj.repositories.local.entities.BankAccount
import com.jmarkstar.cheqdemoproj.repositories.local.entities.SpendingCategory
import com.jmarkstar.cheqdemoproj.repositories.local.entities.Transaction
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

val fakeSpendingCategories = arrayListOf(SpendingCategory(1, "Groceries", "ic_grocery"),
                        SpendingCategory(2, "Restaurants", "ic_restaurant"),
                        SpendingCategory(3, "Household", "ic_household"))

val fakeBanks = arrayListOf(Bank(1, "Westpac", "ic_westpac"),
                        Bank(2, "Commbank", "ic_commbank"))


val fakeBankAccounts = arrayListOf(BankAccount(1, 1, "063-565 4564 7054", "Choice"),
                        BankAccount(2, 1, "063-456 1223 3423", "Saving"),
                        BankAccount(3, 2, "063-234 4534 5667", "Smart Access"),
                        BankAccount(4, 2, "063-234 7889 4534", "NetBank Saver"))

val fakeTransactions : ArrayList<Transaction>
    get() {
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


        val transactions = ArrayList<Transaction>()

        //Westpac
        //this month
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.INCOMING, amount = 4300.30, timestamp = timeStampNow))
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 420.90, timestamp = timeStampNow, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 280.50, timestamp = timeStamp1DayAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 520.00, timestamp = timeStamp4HoursAgo, spendingCategoryId = 3))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.INCOMING, amount = 500.00, timestamp = timeStamp1DayAgo))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 50.90, timestamp = timeStamp4HoursAgo, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 70.50, timestamp = timeStamp4HoursAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 90.00, timestamp = timeStamp1DayAgo, spendingCategoryId = 3))

        //one month ago
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.INCOMING, amount = 4000.40, timestamp = timeStampOneMonthAgo))
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 345.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 450.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 1, type = TransactionType.SPENDING, amount = 1000.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.INCOMING, amount = 2000.30, timestamp = timeStampOneMonthAgo))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 100.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 200.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 2, type = TransactionType.SPENDING, amount = 800.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3))

        //CommBank

        //this month
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.INCOMING, amount = 4500.90, timestamp = timeStampNow))
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 400.90, timestamp = timeStampNow, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 250.50, timestamp = timeStamp4HoursAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 560.00, timestamp = timeStamp1DayAgo, spendingCategoryId = 3))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.INCOMING, amount = 600.60, timestamp = timeStampNow))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 40.90, timestamp = timeStampNow, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 50.50, timestamp = timeStamp4HoursAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 60.00, timestamp = timeStamp1DayAgo, spendingCategoryId = 3))

        //one month ago
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.INCOMING, amount = 5000.20, timestamp = timeStampOneMonthAgo))
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 845.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 670.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 3, type = TransactionType.SPENDING, amount = 1300.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.INCOMING, amount = 3000.10, timestamp = timeStampOneMonthAgo))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 200.90, timestamp = timeStampOneMonthAgo, spendingCategoryId = 1))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 400.50, timestamp = timeStampOneMonthAgo, spendingCategoryId = 2))
        transactions.add(Transaction(bankAccountId = 4, type = TransactionType.SPENDING, amount = 600.00, timestamp = timeStampOneMonthAgo, spendingCategoryId = 3))

        return transactions
    }