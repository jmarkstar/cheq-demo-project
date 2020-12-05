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

    private fun settingAppLogging() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        Timber.plant(CrashlyticsTree())
    }
}