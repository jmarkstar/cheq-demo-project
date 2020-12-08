package com.jmarkstar.cheqdemoproj.presentation

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.jmarkstar.cheqdemoproj.R
import com.jmarkstar.cheqdemoproj.common.BaseTest
import com.jmarkstar.cheqdemoproj.di.RepositoryModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
@ExperimentalCoroutinesApi
class MainActivityTest: BaseTest() {

    @get:Rule val hiltRule = HiltAndroidRule(this)

    @get:Rule val activityRule = ActivityScenarioRule(MainActivity::class.java)

    override fun setUp() {
        super.setUp()
        hiltRule.inject()
    }

    @Test
    fun `test instances`() = testMainDispatcher.runBlockingTest {

        activityRule.scenario.onActivity {

            Assert.assertNotNull(it)
            Assert.assertNotNull(it.balanceRepository)

            runBlocking {
                assert(it.balanceRepository.getBalancesByBank().size == 3)
            }
        }
    }

    @Test
    fun `test textview`() {

        Espresso.onView(ViewMatchers.withId(R.id.tvBalanceCount))
            .check(ViewAssertions.matches(ViewMatchers.withText("3")))
    }

    @After
    fun cleanUp() {
        activityRule.scenario.close()
    }
}