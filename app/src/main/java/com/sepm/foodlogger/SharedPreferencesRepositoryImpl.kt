package com.gojek.gojekbeta

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesRepositoryImpl(context: Context) {
    private val prefs = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)

    fun getPrefs(): SharedPreferences {
        return prefs
    }
}
