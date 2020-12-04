package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.models.Expense
import com.jmarkstar.cheqdemoproj.repositories.local.daos.TransactionDao

class TransactionRepositoryImpl(private val transactionDao: TransactionDao): TransactionRepository {

    override suspend fun getExpensesByCategoryPerMonth(): List<Expense> {
        TODO("Not yet implemented")
    }
}