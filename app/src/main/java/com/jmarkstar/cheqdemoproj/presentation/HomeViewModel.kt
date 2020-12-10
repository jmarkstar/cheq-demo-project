package com.jmarkstar.cheqdemoproj.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jmarkstar.cheqdemoproj.repositories.BalanceRepository
import com.jmarkstar.cheqdemoproj.repositories.TransactionRepository

class HomeViewModel @ViewModelInject constructor(private val balanceRepository: BalanceRepository,
                                    private val transactionRepository: TransactionRepository,
                                    @Assisted private val savedStateHandle: SavedStateHandle? = null) : ViewModel() {

    val balances = liveData {
        emit(balanceRepository.getAllBankAccountsBalance())
    }

    val expenses = liveData {
        emit(transactionRepository.getExpensesByCategoryPerMonth())
    }
}