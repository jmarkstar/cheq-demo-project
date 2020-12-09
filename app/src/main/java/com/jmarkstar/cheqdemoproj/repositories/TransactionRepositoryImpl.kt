package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.repositories.local.daos.TransactionDao
import javax.inject.Inject

/** This repositories in returning the data directly, I'm not managing the errors.
 * */
class TransactionRepositoryImpl @Inject constructor(private val transactionDao: TransactionDao): TransactionRepository {

    override suspend fun getExpensesByCategoryPerMonth() = transactionDao.getExpensesByMonthAndCategory()
}