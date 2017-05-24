package com.boyukliev.base

import android.app.Application
import com.boyukliev.base.dagger.application.AndroidModule
import com.boyukliev.base.dagger.application.ApplicationComponent
import com.boyukliev.base.dagger.application.ApplicationModule
import com.boyukliev.base.dagger.application.DaggerApplicationComponent

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
class BaseApp : Application() {

    var applicationComponent: ApplicationComponent? = null
        get
        private set

    override fun onCreate() {
        super.onCreate()

        buildApplicationComponent()
        injectApplicationComponent()
    }

    @Suppress("DEPRECATION")
    fun buildApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .androidModule(AndroidModule())
                .build()
    }

    fun injectApplicationComponent() {
        applicationComponent?.inject(this)
    }
}