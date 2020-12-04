package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.models.Balance

interface BalanceRepository {

    suspend fun getAllBankAccountsBalance(): List<Balance>

    suspend fun getBalancesByBank(): List<Balance>
}