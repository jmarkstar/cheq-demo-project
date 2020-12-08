package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.repositories.local.daos.TransactionDao
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(private val transactionDao: TransactionDao): TransactionRepository {

    override suspend fun getExpensesByCategoryPerMonth() = transactionDao.getExpensesByMonthAndCategory()
}