package com.boyukliev.base.presentation.ui.login

import com.boyukliev.base.dagger.scope.PerActivity
import com.boyukliev.base.domain.executor.PostExecutionThread
import com.boyukliev.base.domain.executor.ThreadExecutor
import com.boyukliev.base.domain.usecase.LoginInteractor
import dagger.Module
import dagger.Provides

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@Module
class LoginActivityModule(private var loginActivity: LoginActivity) {

    @PerActivity
    @Provides
    fun provideActivity(): LoginActivity {
        return loginActivity
    }

    @PerActivity
    @Provides
    fun providePresenter(loginInteractor: LoginInteractor): LoginActivityPresenter {
        return LoginActivityPresenter(loginInteractor)
    }

    @PerActivity
    @Provides
    fun provideLoginInteractor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread): LoginInteractor {
        return LoginInteractor(threadExecutor, postExecutionThread)
    }
}