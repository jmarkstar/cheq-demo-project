package com.jmarkstar.cheqdemoproj.presentation

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.di.RepositoryModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.After

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
@ExperimentalCoroutinesApi
class MainActivityTest : BaseTest() {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    override fun setUp() {
        super.setUp()
        hiltRule.inject()
    }

    @Test
    fun `test instances`() = testMainDispatcher.runBlockingTest {

        activityRule.scenario.onActivity {

            Assert.assertNotNull(it)
        }
    }
    /*
    @Test
    fun `test textview`() {

        Espresso.onView(ViewMatchers.withId(R.id.tvBalanceCount))
            .check(ViewAssertions.matches(ViewMatchers.withText("$allBankAccountsBalanceCount")))
    }*/

    @After
    fun cleanUp() {
        activityRule.scenario.close()
    }
}
