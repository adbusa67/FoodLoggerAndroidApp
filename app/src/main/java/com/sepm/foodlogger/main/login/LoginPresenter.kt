package com.gojek.gojekbeta.main.login

class LoginPresenter(val view: LoginContract.View, private val model: LoginModel) :
    LoginContract.Presenter {

    override fun saveData(email: String, password: String) {
        model.saveCredentials(email, password)
        view.openHomePage(email)
    }
}
