package com.gojek.gojekbeta.main.login

interface LoginContract {

    interface Presenter {
        fun saveData(email: String, password: String)
    }

    interface View {
        fun openHomePage(email: String)
    }
}