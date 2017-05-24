package com.boyukliev.base.presentation.ui.base

import android.support.v7.app.AppCompatActivity
import com.boyukliev.base.BaseApp
import com.boyukliev.base.dagger.activity.ActivityComponent
import com.boyukliev.base.dagger.application.ApplicationComponent

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
abstract class BaseActivity<A: ActivityComponent> : AppCompatActivity() {

    protected var applicationComponent: ApplicationComponent? = null
        get() = (application as BaseApp).applicationComponent

    var activityComponent: A? = null

    abstract fun injectActivityComponent()
}