package com.boyukliev.base.dagger.application

import com.boyukliev.base.BaseApp
import dagger.Component
import javax.inject.Singleton

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@Singleton
@Component(modules = arrayOf(AndroidModule::class, ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: BaseApp)
}