package com.boyukliev.base.dagger.application

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@dagger.Module
class ApplicationModule(private val application: android.app.Application) {
    @javax.inject.Singleton
    @dagger.Provides
    fun provideApplication(): android.app.Application {
        return application
    }
}