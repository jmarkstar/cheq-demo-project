package com.jmarkstar.cheqdemoproj.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jmarkstar.cheqdemoproj.common.formatted
import com.jmarkstar.cheqdemoproj.presentation.home.CardItem
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
                "$${allAccountTotalBills.formatted()}",
                "$${allAccountTotalCash.formatted()}", "", true)

        cards.add(card)

        //Get bank card info

        val bankNames = balances.map { it.bankName }

        bankNames.forEach {  bankName ->

            val balancesBank = balances.filter { it.bankName == bankName }

            val bankTotalSpent = balancesBank.map { it.spent }.sum()
            val bankTotalIncome = balancesBank.map { it.income }.sum()
            val bankBalance = bankTotalIncome - bankTotalSpent

            val bankCard = CardItem(bankName, balancesBank[0].bankIcon,
                    "$${bankBalance.formatted()}",
                    "$${bankTotalSpent.formatted()}",
                    "$${bankTotalIncome.formatted()}",
                    "4hrs ago",
                    false)

            cards.add(bankCard)
        }

        emit(cards)
    }

    val expenses = liveData {
        emit(transactionRepository.getExpensesByCategoryPerMonth())
    }
}