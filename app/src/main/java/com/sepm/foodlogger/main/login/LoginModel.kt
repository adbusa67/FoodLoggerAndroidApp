package com.gojek.gojekbeta.main.login

import android.content.Context
import com.gojek.gojekbeta.EMAIL
import com.gojek.gojekbeta.PASSWORD
import com.gojek.gojekbeta.SharedPreferencesRepositoryImpl

class LoginModel(val context: Context) {

    private val sharedPreferencesRepository = SharedPreferencesRepositoryImpl(context)
    private val sharedPref = sharedPreferencesRepository.getPrefs()

    fun saveCredentials(email: String, password: String) {
        with(sharedPref.edit()) {
            putString(EMAIL, email)
            putString(PASSWORD, password)
            apply()
        }
    }
}
