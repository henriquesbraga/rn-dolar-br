package com.henriquesbraga.dollarappkt.api

import com.henriquesbraga.dollarappkt.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("all/USD-BRL")
    fun getDollar(): Call<ApiResponse>
}