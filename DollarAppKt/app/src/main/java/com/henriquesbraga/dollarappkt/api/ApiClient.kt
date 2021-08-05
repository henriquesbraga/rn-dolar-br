package com.henriquesbraga.dollarappkt.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

class ApiClient {

    companion object{
        private val BASE_URL = "https://economia.awesomeapi.com.br/"
        private lateinit var retrofit: Retrofit

        private val contentType: MediaType = MediaType.parse("application/json")!!

        fun getApiClient(): Retrofit {
            if(!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory(contentType))
                    .build()
            }
            return retrofit
        }
    }


}