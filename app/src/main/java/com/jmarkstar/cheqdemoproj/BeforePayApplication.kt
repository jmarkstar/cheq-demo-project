package com.jmarkstar.cheqdemoproj

import android.app.Application
import com.jmarkstar.cheqdemoproj.common.CrashlyticsTree
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import timber.log.Timber

@HiltAndroidApp
open class BeforePayApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setupAppLogging()
        setupFonts()
    }

    /** Shows logs only on the debug mode.
     * */
    private fun setupAppLogging() {
        //As OWASP suggestions, we need to be careful logging data on release.
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        Timber.plant(CrashlyticsTree())
    }

    private fun setupFonts() {
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/SF-UI-Text-Regular.otf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                ).build()
        )
    }
}