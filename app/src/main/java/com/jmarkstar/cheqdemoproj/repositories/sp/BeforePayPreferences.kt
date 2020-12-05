package com.jmarkstar.cheqdemoproj.repositories.sp

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.jmarkstar.cheqdemoproj.BuildConfig
import com.jmarkstar.cheqdemoproj.common.security.Passphrases

/* EncryptedSharedPreferences to store some data on release. */
class BeforePayPreferences(context: Context) {

    private val sharedPreferencesName = "before_pay_prefs"

    private var sharedPreferences = if (BuildConfig.enableEncryption) {
        EncryptedSharedPreferences.create(
            context,
            "secret_$sharedPreferencesName",
            MasterKey.Builder(context, Passphrases.spPassphrase).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM)
    } else {
        context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
    }

}