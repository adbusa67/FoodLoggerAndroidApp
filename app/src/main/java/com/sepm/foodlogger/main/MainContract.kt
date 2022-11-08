package com.gojek.gojekbeta.main

interface MainContract {

    interface Presenter {
        fun loginCredentials()
    }

    interface View {
        fun openHomePage(email: String)
        fun loadLoginFragment()
    }
}
