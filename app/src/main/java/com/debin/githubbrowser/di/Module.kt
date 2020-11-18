package com.debin.githubbrowser.di

import com.debin.githubbrowser.network.RetrofitInstance
import com.debin.githubbrowser.repository.SearchUserRepository
import com.debin.githubbrowser.repository.SearchUserRespositoryImpl
import org.koin.core.definition.Kind
import org.koin.dsl.module


val networkModule = module{
single { RetrofitInstance().retrofitClient()}
}

val repositoriesModule = module {
    single<SearchUserRepository> { SearchUserRespositoryImpl(get(), get()) }
}