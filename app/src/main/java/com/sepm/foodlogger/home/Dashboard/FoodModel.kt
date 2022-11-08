package com.gojek.gojekbeta.home.Dashboard

import android.net.Uri
import android.util.Log
import com.gojek.gojekbeta.home.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "http://10.0.0.33:8080/"

class RecycleModel {

    fun getData(uri: Uri, onSuccess: (FoodData) -> Unit, onFail: (Throwable) -> Unit) {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        val api : Api = retrofit.create(Api::class.java)
        val call : Call<FoodData> = api.getData(uri)

        call.enqueue(
            object : Callback<FoodData> {
                override fun onFailure(call: Call<FoodData>, t: Throwable) {
                    onFail(t)
                }

                override fun onResponse(call: Call<FoodData>, response: Response<FoodData>) {
                    val foodData = response.body()
                    Log.d("Food Data", foodData.toString())
                    if (foodData != null) {
                        onSuccess(foodData)
                    }
                }
            }
        )
    }
}
