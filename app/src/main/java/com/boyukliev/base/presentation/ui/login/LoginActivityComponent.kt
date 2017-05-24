package com.boyukliev.base.presentation.ui.login

import com.boyukliev.base.dagger.activity.ActivityComponent
import com.boyukliev.base.dagger.scope.PerActivity
import dagger.Subcomponent

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@PerActivity
@Subcomponent(modules = arrayOf(LoginActivityModule::class))
interface LoginActivityComponent: ActivityComponent {
    fun inject(loginActivity: LoginActivity)
}