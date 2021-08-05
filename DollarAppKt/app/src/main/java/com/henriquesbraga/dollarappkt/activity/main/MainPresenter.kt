package com.henriquesbraga.dollarappkt.activity.main

import android.util.Log
import com.henriquesbraga.dollarappkt.api.ApiClient
import com.henriquesbraga.dollarappkt.api.ApiInterface
import com.henriquesbraga.dollarappkt.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(view: MainView) {

    private var view = view

    fun getData(){
        view.showLoading()
        val apiInterface: ApiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)

        var call: Call<ApiResponse> = apiInterface.getDollar()
        call.enqueue(object: Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                view.hideLoading()
                if(response.isSuccessful && response.body() != null) {
                    view.onGetResult(response.body()!!)

                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                view.hideLoading()
                view.onErrorLoading(t.localizedMessage)
                Log.d("error", "localizedmessage: " + t.localizedMessage.toString())
            }

        })
    }

}