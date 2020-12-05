package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.models.Balance
import com.jmarkstar.cheqdemoproj.repositories.local.daos.BankDao
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

// This Repository only will use the local database as a source but I could also use an API as another source.
class BalanceRepositoryImpl @Inject constructor(val bankDao: BankDao): BalanceRepository {

    override suspend fun getAllBankAccountsBalance(): List<Balance> {
        TODO("Not yet implemented")
    }

    override suspend fun getBalancesByBank(): List<Balance> {
        val list = ArrayList<Balance>()
        list.add(Balance("Nab","", Date(), 200.00, 500.00))
        list.add(Balance("CommonwealthBank","", Date(), 300.00, 5000.00))
        list.add(Balance("ANZ","", Date(), 280.00, 300.00))
        return list
    }
}