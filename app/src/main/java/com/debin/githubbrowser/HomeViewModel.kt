package com.debin.githubbrowser

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.debin.githubbrowser.datasource.GitUser
import com.debin.githubbrowser.repository.SearchUserRepository
import com.debin.githubbrowser.util.StateResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect

class HomeViewModel(private val searchUserRepository: SearchUserRepository) : ViewModel() {

    private val uiScope = CoroutineScope(Dispatchers.Main)
    val progress = MutableLiveData<Integer>()
    private val _userList = MutableLiveData<List<GitUser>>()
    val userList : LiveData<List<GitUser>>
    get() = _userList

    @InternalCoroutinesApi
    private suspend fun searchUser(userName: String) {
        searchUserRepository.searchUser(userName).collect { state ->
            when (state) {
                is StateResponse.Loading -> {
                    progress.value = 0 as Integer
                }
                is StateResponse.Success -> {
                    progress.value = 8 as Integer
                    _userList.postValue(state.data)
                }
                is StateResponse.Failed -> {
                    progress.value = 8 as Integer
                }
            }
        }
    }

}