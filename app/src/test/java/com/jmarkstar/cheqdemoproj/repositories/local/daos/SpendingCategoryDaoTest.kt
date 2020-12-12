package com.jmarkstar.cheqdemoproj.repositories.local.daos

import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.di.RepositoryModule
import com.jmarkstar.cheqdemoproj.repositories.local.fakeSpendingCategories
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
class SpendingCategoryDaoTest : BaseTest() {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var spendingCategoryDao: SpendingCategoryDao

    override fun setUp() {
        super.setUp()
        hiltRule.inject()
    }

    @Test
    fun `test spending category count`() = runBlocking {
        Assert.assertNotNull(spendingCategoryDao)
        Assert.assertEquals(fakeSpendingCategories.size, spendingCategoryDao.count())
    }

    @Test
    fun `test spending categories values`() = runBlocking {
        Assert.assertTrue(
            fakeSpendingCategories.containsAll(
                spendingCategoryDao.getAllSpendingCategories()
            )
        )
    }

    // Add more unit test
}
