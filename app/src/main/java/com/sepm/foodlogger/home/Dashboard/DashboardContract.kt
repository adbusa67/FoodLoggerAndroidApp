package com.gojek.gojekbeta.home.Dashboard

import android.net.Uri

interface DashboardContract {

    interface Presenter {
        fun getData(uri: Uri)
    }

    interface View {
        fun setData(data: FoodData)
        fun onFail(t: Throwable)
    }
}
