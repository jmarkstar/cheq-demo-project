package com.jmarkstar.cheqdemoproj.presentation.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jmarkstar.cheqdemoproj.common.formatted
import com.jmarkstar.cheqdemoproj.repositories.BalanceRepository
import com.jmarkstar.cheqdemoproj.repositories.TransactionRepository

class HomeViewModel @ViewModelInject constructor(private val balanceRepository: BalanceRepository,
                                    private val transactionRepository: TransactionRepository,
                                    @Assisted private val savedStateHandle: SavedStateHandle? = null) : ViewModel() {

    val balances = liveData {
        val balances = balanceRepository.getAllBankAccountsBalance()

        val cards = ArrayList<CardItem>()

        //Get all account card info
        val allAccountTotalBills = balances.map { it.spent }.sum()
        val allAccountTotalCash = balances.map { it.income }.sum()
        val allAccountBalance = allAccountTotalCash - allAccountTotalBills

        val card = CardItem("All accounts","",
                "$${allAccountBalance.formatted()}",
                "$${allAccountTotalBills.toInt()}",
                "$${allAccountTotalCash.toInt()}", "", true)

        cards.add(card)

        //Get bank card info

        val bankNames = balances.map { it.bankName }.toSet()

        bankNames.forEach {  bankName ->

            val balancesBank = balances.filter { it.bankName == bankName }

            val bankTotalSpent = balancesBank.map { it.spent }.sum()
            val bankTotalIncome = balancesBank.map { it.income }.sum()
            val bankBalance = bankTotalIncome - bankTotalSpent

            val bankCard = CardItem(bankName, balancesBank[0].bankIcon,
                    "$${bankBalance.toInt()}",
                    "$${bankTotalSpent.toInt()}",
                    "$${bankTotalIncome.toInt()}",
                    "4hrs ago",
                    false)

            cards.add(bankCard)
        }

        emit(cards.toRecyclerItems())
    }

    val expenses = liveData {
        emit(transactionRepository.getExpensesByCategoryPerMonth())
    }
}