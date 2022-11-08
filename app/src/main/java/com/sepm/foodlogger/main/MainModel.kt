package com.gojek.gojekbeta.main

import android.content.Context
import com.gojek.gojekbeta.DEFAULT_VALUE
import com.gojek.gojekbeta.EMAIL
import com.gojek.gojekbeta.PASSWORD
import com.gojek.gojekbeta.SharedPreferencesRepositoryImpl

class MainModel(val context: Context) {

    private val sharedPreferencesRepository = SharedPreferencesRepositoryImpl(context)
    private val sharedPref = sharedPreferencesRepository.getPrefs()

    fun getCredentials(): Pair<String?, String?> {
        val email = sharedPref.getString(EMAIL, DEFAULT_VALUE)
        val password = sharedPref.getString(PASSWORD, DEFAULT_VALUE)
        return Pair(email, password)
    }
}
