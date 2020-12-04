package com.jmarkstar.cheqdemoproj

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BeforePayApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}