package com.example.workshopapp

import android.app.Application
import com.example.workshopapp.domain.resource.IResourceProvider
import com.example.workshopapp.domain.resource.ResourceProvider

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        private lateinit var app: App
        val resourceProvider: IResourceProvider by lazy(LazyThreadSafetyMode.NONE) {
            ResourceProvider(app.resources)
        }
    }
}