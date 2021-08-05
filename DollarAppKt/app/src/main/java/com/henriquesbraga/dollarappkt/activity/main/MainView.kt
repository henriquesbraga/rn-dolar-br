package com.henriquesbraga.dollarappkt.activity.main

import com.henriquesbraga.dollarappkt.model.ApiResponse
import com.henriquesbraga.dollarappkt.model.USD

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun onGetResult(apiResponse: ApiResponse)
    fun onErrorLoading(message: String)
}