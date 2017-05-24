package com.boyukliev.base.dagger.application

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@Module
class ApplicationModule(private val application: Application) {
    @Singleton
    @Provides
    fun provideApplication(): Application {
        return application
    }
}