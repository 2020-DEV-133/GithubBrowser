package com.debin.githubbrowser

import android.app.Application
import com.debin.githubbrowser.di.networkModule
import com.debin.githubbrowser.di.repositoriesModule
import com.debin.githubbrowser.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubBrowserApp : Application() {

    private val appComponentModules = mutableListOf(networkModule, repositoriesModule, viewmodelModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appComponentModules)
        }
    }
}