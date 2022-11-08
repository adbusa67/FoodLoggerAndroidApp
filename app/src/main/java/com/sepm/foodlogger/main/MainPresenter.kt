package com.gojek.gojekbeta.main

import com.gojek.gojekbeta.DEFAULT_VALUE

class MainPresenter(private val view: MainContract.View, private val model: MainModel) :
    MainContract.Presenter {

    override fun loginCredentials() {
        val (email, password) = model.getCredentials()
        if (email != DEFAULT_VALUE && password != DEFAULT_VALUE)
            view.openHomePage(email.orEmpty())
        else
            view.loadLoginFragment()
    }
}
