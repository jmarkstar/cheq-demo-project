package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.models.Balance
import com.jmarkstar.cheqdemoproj.repositories.local.daos.BankDao

class BalanceRepositoryImpl(val bankDao: BankDao): BalanceRepository {

    override suspend fun getAllBankAccountsBalance(): List<Balance> {
        TODO("Not yet implemented")
    }

    override suspend fun getBalancesByBank(): List<Balance> {
        TODO("Not yet implemented")
    }
}