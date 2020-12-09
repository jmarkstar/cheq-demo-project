package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.repositories.local.daos.BankAccountDao
import com.jmarkstar.cheqdemoproj.repositories.local.daos.BankDao
import javax.inject.Inject

/** This repositories in returning the data directly, I'm not managing the errors.
 * */
class BalanceRepositoryImpl @Inject constructor(private val bankDao: BankDao,
                            private val bankAccountDao: BankAccountDao): BalanceRepository {

    override suspend fun getAllBankAccountsBalance() = bankAccountDao.getAllBalanceByAccountName()

    override suspend fun getBalancesBy(bankId: Int) = bankDao.getBalanceBy(bankId)
}