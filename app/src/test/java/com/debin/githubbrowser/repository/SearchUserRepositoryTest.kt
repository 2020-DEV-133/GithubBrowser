package com.debin.githubbrowser.repository

import com.debin.githubbrowser.datasource.GitUserTest
import com.debin.githubbrowser.network.ApiService
import com.debin.githubbrowser.util.StateResponse
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.stub
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert.assertEquals
import org.junit.Test


class SearchUserRepositoryTest {

    val testDispacher = TestCoroutineDispatcher()
    val apiService = mock<ApiService>()
    val repository = SearchUserRespositoryImpl(apiService, testDispacher)

    @InternalCoroutinesApi
    @Test
    fun `flow emits successfully`() = runBlocking{
        //Mock Api Service
        val gitUser = GitUserTest("https://avatars3.githubusercontent.com/u/69631?v=4", "",
            69631, "Menlo Park, California", "facebook", "Facebook", "https://api.github.com/users/facebook/repos" )
        val gitUserList = listOf<GitUserTest>(gitUser)
//            apiService.stub {
//                runBlocking { apiService.searchUser("facebook") } doReturn gitUserList
//            }
        val flow = repository.searchUser("facebook")
        //verify
        flow.collect { state ->
            when(state) {
                is StateResponse.Success -> {
                   assertEquals(state.data, gitUserList)
                }
            }
        }
    }
}