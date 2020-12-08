package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.repositories.local.daos.TransactionDao
import javax.inject.Inject

// This Repository only will use the local database as a source but I could also use an API as another source.
class TransactionRepositoryImpl @Inject constructor(private val transactionDao: TransactionDao): TransactionRepository {

    override suspend fun getExpensesByCategoryPerMonth() = transactionDao.getExpensesByMonthAndCategory()
}