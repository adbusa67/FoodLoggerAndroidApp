package com.gojek.gojekbeta.home

import android.content.Context
import com.gojek.gojekbeta.EMAIL
import com.gojek.gojekbeta.PASSWORD
import com.gojek.gojekbeta.SharedPreferencesRepositoryImpl

class HomeModel(val context: Context) {
    private val sharedPreferencesRepository = SharedPreferencesRepositoryImpl(context)
    private val sharedPref = sharedPreferencesRepository.getPrefs()

    fun destroyCredentials() {
        with(sharedPref.edit()) {
            remove(EMAIL)
            remove(PASSWORD)
            apply()
        }
    }
}
