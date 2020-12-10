package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.allBankAccountsBalanceCount
import com.jmarkstar.cheqdemoproj.allBankBalancesCount
import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.di.RepositoryModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
@ExperimentalCoroutinesApi
class BalanceRepositoryTest: BaseTest() {

    private val bankId = 1

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject lateinit var balanceRepository: BalanceRepository

    override fun setUp() {
        super.setUp()
        hiltRule.inject()
    }

    @Test
    fun `test all account balances`() = runBlocking {

        val balances = balanceRepository.getAllBankAccountsBalance()

        Assert.assertEquals(allBankAccountsBalanceCount, balances.size)
    }

    @Test
    fun `test balances by bank`() = runBlocking {

        val balances = balanceRepository.getBalancesBy(bankId)

        Assert.assertEquals(allBankBalancesCount, balances.size)
    }

    //Add more unit test
}