package com.example.demoandroidsecurepersist

import android.app.Application
import com.example.demoandroidsecurepersist.di.libraryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DemoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DemoApplication)

            modules(
                libraryModule
            )
        }
    }
}