package com.jmarkstar.cheqdemoproj.presentation.home

import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.models.Balance
import com.jmarkstar.cheqdemoproj.repositories.BalanceRepository
import com.jmarkstar.cheqdemoproj.repositories.TransactionRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest: BaseTest() {

    private val balanceRepository = mockk<BalanceRepository>()

    private val transactionRepository = mockk<TransactionRepository>()

    private lateinit var homeViewModel: HomeViewModel

    override fun setUp() {
        super.setUp()
        homeViewModel = HomeViewModel(balanceRepository, transactionRepository)
    }

    @Test
    fun `test card item size with two banks success`() {

        //given
        val commBankName = "Commbank"
        val commBankIconName = "ic_commbank"
        val westpacName = "Westpac"
        val westpaIconName = "ic_westpac"

        val commBankBalance1 = mockk<Balance>()
        val commBankBalance2 = mockk<Balance>()
        val westpacBalance1 = mockk<Balance>()
        val westpacBalance2 = mockk<Balance>()

        val balances = arrayListOf(commBankBalance1, commBankBalance2, westpacBalance1, westpacBalance2)

        every { commBankBalance1.bankName } returns commBankName
        every { commBankBalance1.bankIcon } returns commBankIconName
        every { commBankBalance1.spent } returns 0.0
        every { commBankBalance1.income } returns 0.0

        every { commBankBalance2.bankName } returns commBankName
        every { commBankBalance2.bankIcon } returns commBankIconName
        every { commBankBalance2.spent } returns 0.0
        every { commBankBalance2.income } returns 0.0

        every { westpacBalance1.bankName } returns westpacName
        every { westpacBalance1.bankIcon } returns westpaIconName
        every { westpacBalance1.spent } returns 0.0
        every { westpacBalance1.income } returns 0.0

        every { westpacBalance2.bankName } returns westpacName
        every { westpacBalance2.bankIcon } returns westpaIconName
        every { westpacBalance2.spent } returns 0.0
        every { westpacBalance2.income } returns 0.0

        coEvery { balanceRepository.getAllBankAccountsBalance() } returns balances

        //when
        homeViewModel.balances.observeForever {}
        val resultSize = homeViewModel.balances.value?.size ?: 0

        //then

        //allaccounts, westpac and commbank = 3
        Assert.assertEquals(3, resultSize)
    }
}