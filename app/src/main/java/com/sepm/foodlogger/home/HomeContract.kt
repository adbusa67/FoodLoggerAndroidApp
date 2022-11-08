package com.gojek.gojekbeta.home

interface HomeContract {
    interface Presenter {
        fun logout()
    }

    interface View {
        fun openLoginPage()
    }
}