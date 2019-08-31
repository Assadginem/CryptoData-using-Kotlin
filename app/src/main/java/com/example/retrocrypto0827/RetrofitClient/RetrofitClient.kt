package com.example.retrocrypto0827.RetrofitClient

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var ourInstance: Retrofit?=null


    val instance: Retrofit
    get(){
        if(ourInstance == null){
            ourInstance = Retrofit.Builder()
                .baseUrl("https://api.nomics.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return ourInstance!!
    }


}