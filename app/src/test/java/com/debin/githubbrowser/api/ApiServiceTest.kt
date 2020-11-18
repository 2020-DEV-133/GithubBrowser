package com.debin.githubbrowser.api

import com.debin.githubbrowser.network.ApiService
import com.debin.githubbrowser.util.Constants.BASE_URL
import com.debin.githubbrowser.util.StateResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.flow.collect
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiServiceTest {

    private lateinit var apiService: ApiService
    private lateinit var mockWebServer : MockWebServer

    @Before
    fun createService() {
         mockWebServer = MockWebServer()
         apiService = Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .addCallAdapterFactory(CoroutineCallAdapterFactory())
             .build().create(ApiService::class.java)
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    @Test
    suspend fun getUser() {
      val facebook = apiService.searchUser("facebook")

    }


}

