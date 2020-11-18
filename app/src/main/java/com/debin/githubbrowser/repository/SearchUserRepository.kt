package com.debin.githubbrowser.repository

import androidx.lifecycle.LiveData
import com.debin.githubbrowser.datasource.GitUser
import com.debin.githubbrowser.datasource.GitUserTest
import com.debin.githubbrowser.util.StateResponse
import kotlinx.coroutines.flow.Flow

interface SearchUserRepository {
    suspend fun searchUser(userName : String) : Flow<StateResponse<GitUser>>
}