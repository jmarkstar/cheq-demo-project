package com.jmarkstar.cheqdemoproj.common

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

private const val CRASHLYTICS_KEY_PRIORITY = "priority"
private const val CRASHLYTICS_KEY_TAG = "tag"
private const val CRASHLYTICS_KEY_MESSAGE = "message"

class CrashlyticsTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        FirebaseCrashlytics.getInstance().setCustomKey(CRASHLYTICS_KEY_PRIORITY, priority)
        tag?.apply {
            FirebaseCrashlytics.getInstance().setCustomKey(CRASHLYTICS_KEY_TAG, this)
        }
        FirebaseCrashlytics.getInstance().setCustomKey(CRASHLYTICS_KEY_MESSAGE, message)

        if (t == null) {
            FirebaseCrashlytics.getInstance().recordException(Exception(message))
        } else {
            FirebaseCrashlytics.getInstance().recordException(t)
        }
    }
}
