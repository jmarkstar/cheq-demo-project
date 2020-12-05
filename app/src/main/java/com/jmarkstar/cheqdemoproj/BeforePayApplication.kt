package com.jmarkstar.cheqdemoproj

import android.app.Application
import com.jmarkstar.cheqdemoproj.common.CrashlyticsTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BeforePayApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        settingAppLogging()
    }

    /** Shows logs only on the debug mode.
     * */
    private fun settingAppLogging() {
        //As OWASP suggestions, we need to be careful logging data on release.
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        Timber.plant(CrashlyticsTree())
    }
}