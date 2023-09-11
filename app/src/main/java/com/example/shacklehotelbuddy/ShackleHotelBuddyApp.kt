package com.example.shacklehotelbuddy

import android.app.Application
import com.example.shacklehotelbuddy.di.coroutineDispatcherModule
import com.example.shacklehotelbuddy.di.networkModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import timber.log.Timber

class ShackleHotelBuddyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            if (BuildConfig.DEBUG) {
                AndroidLogger()
            } else {
                EmptyLogger()
            }
            androidContext(this@ShackleHotelBuddyApp)
            modules(
                listOf(
                    networkModule,
                    coroutineDispatcherModule,
                    searchHotelsModule,
                )
            )
        }
    }
}