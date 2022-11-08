package com.gojek.gojekbeta.home

import android.net.Uri
import com.gojek.gojekbeta.home.Dashboard.FoodData
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @POST("upload")
    fun getData(@Path("uri") uri: Uri) : Call<FoodData>
}
