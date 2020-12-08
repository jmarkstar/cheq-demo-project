package com.jmarkstar.cheqdemoproj.repositories.local.daos

import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.di.RepositoryModule
import com.jmarkstar.cheqdemoproj.repositories.local.fakeBankAccounts
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
class BankAccountDaoTest: BaseTest() {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var bankAccountDao: BankAccountDao

    override fun setUp() {
        super.setUp()
        hiltRule.inject()
    }

    @Test
    fun `test bank count`() = runBlocking {
        Assert.assertNotNull(bankAccountDao)
        Assert.assertEquals(fakeBankAccounts.size, bankAccountDao.count())
    }
}