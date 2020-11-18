package com.debin.githubbrowser.network

import androidx.lifecycle.LiveData
import com.debin.githubbrowser.datasource.GitUser
import com.debin.githubbrowser.datasource.GitUserTest
import com.debin.githubbrowser.util.StateResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{username}")
      suspend fun searchUser(@Path("username") userName : String) : GitUser
}