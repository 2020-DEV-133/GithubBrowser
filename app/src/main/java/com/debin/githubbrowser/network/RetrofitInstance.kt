package com.debin.githubbrowser.network

import com.debin.githubbrowser.util.Constants.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    var client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    fun retrofitClient() : ApiService {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .client(client)
          .addCallAdapterFactory(CoroutineCallAdapterFactory())
          .addConverterFactory(GsonConverterFactory.create())
          .build().create(ApiService::class.java)
    }
}