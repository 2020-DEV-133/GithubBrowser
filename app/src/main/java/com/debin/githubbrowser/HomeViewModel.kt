package com.debin.githubbrowser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.debin.githubbrowser.datasource.GitUser
import com.debin.githubbrowser.repository.SearchUserRepository
import com.debin.githubbrowser.util.StateResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val searchUserRepository: SearchUserRepository) : ViewModel() {

    private val uiScope = CoroutineScope(Dispatchers.Main)
    val progress = MutableLiveData<Int>()
    var searchUser = MutableLiveData<String>()
    private lateinit var searchKey: String
    private val _userList = MutableLiveData<GitUser>()
    val userList: LiveData<GitUser>
        get() = _userList

    init {
        progress.value = 8
    }


    private suspend fun searchUser(userName: String) {
        searchUserRepository.searchUser(userName).collect { state ->
            when (state) {
                is StateResponse.Loading -> {
                    progress.value = 0
                }
                is StateResponse.Success -> {
                    progress.value = 8
                    println("Response is ::: ${state.data}")
                    _userList.postValue(state.data)
                }
                is StateResponse.Failed -> {
                    println("Response is ::: ${state.message}")
                    progress.value = 8
                }
            }
        }
    }


    fun searchUser() {
        searchKey = searchUser.value.orEmpty().trim()
        println("Search value :: ${searchKey}")
        if (searchKey.isEmpty()) {
            uiScope.launch {
                searchUser("facebook")
            }
        }
    }
}