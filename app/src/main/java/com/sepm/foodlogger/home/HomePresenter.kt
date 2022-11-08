package com.gojek.gojekbeta.home

class HomePresenter(val view: HomeContract.View, private val model: HomeModel) :
    HomeContract.Presenter {

    override fun logout() {
        model.destroyCredentials()
        view.openLoginPage()
    }
}
