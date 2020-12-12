package com.jmarkstar.cheqdemoproj.repositories

import com.jmarkstar.cheqdemoproj.allExpensesByCategoryCount
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
class TransactionRepositoryTest : BaseTest() {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var transactionRepository: TransactionRepository

    override fun setUp() {
        super.setUp()
        hiltRule.inject()
    }

    @Test
    fun `test expenses by category per month count`() = runBlocking {

        val expenses = transactionRepository.getExpensesByCategoryPerMonth()

        Assert.assertEquals(allExpensesByCategoryCount, expenses.size)
    }

    // Add more unit test
}
