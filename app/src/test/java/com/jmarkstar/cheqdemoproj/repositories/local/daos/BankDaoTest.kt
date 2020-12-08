package com.jmarkstar.cheqdemoproj.repositories.local.daos

import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.di.RepositoryModule
import com.jmarkstar.cheqdemoproj.repositories.local.fakeBanks
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
@ExperimentalCoroutinesApi
class BankDaoTest: BaseTest() {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject lateinit var bankDao: BankDao

    @Before
    override fun setUp() {
        super.setUp()
        hiltRule.inject()
    }

    @Test
    fun `test bank count`() = runBlocking {
        assertNotNull(bankDao)
        assertEquals(fakeBanks.size, bankDao.count())
    }
}