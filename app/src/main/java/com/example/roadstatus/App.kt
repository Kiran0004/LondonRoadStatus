package com.example.roadstatus

import android.app.Application
import com.example.data.di.networkModule
import com.example.roadstatus.di.appModule
import com.example.roadstatus.di.interactorsModule
import com.example.roadstatus.di.mappersModule
import com.example.roadstatus.di.repositoryModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule,
            repositoryModule,
            interactorsModule,
            mappersModule,
            networkModule))
    }
}
