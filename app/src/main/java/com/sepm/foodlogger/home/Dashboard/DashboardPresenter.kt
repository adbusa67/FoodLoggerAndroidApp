package com.gojek.gojekbeta.home.Dashboard

import android.net.Uri

class DashboardPresenter(
    private val view: DashboardContract.View,
    private val model: RecycleModel
) :
    DashboardContract.Presenter {

    override fun getData(uri: Uri) {
        model.getData(
            uri,
            {
                view.setData(FoodData("Apple", 1000))
            },
            {
                view.onFail(it)
            }
        )
    }
}
