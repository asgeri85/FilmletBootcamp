package com.example.filmlerkotlinbootcamp.servis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetorfitClient {
    companion object{
        fun getRetrofit(url:String):Retrofit{
            return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}