package com.jmarkstar.cheqdemoproj.presentation.home

import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.models.Balance
import com.jmarkstar.cheqdemoproj.presentation.HomeViewModel
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
    fun `test balance size list`() {

        //given
        val balancesSize = 10
        val balances = mockk<List<Balance>>()
        every { balances.size } returns balancesSize
        coEvery { balanceRepository.getAllBankAccountsBalance() } returns balances

        //when
        homeViewModel.balances.observeForever {}
        val resultSize = homeViewModel.balances.value?.size ?: 0

        //then
        Assert.assertEquals(balancesSize, resultSize)
    }
}