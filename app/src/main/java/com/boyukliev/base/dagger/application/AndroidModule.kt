package com.boyukliev.base.dagger.application

import android.app.Application
import com.boyukliev.base.domain.executor.PostExecutionThread
import com.boyukliev.base.domain.executor.ThreadExecutor
import com.boyukliev.base.presentation.executor.JobExecutor
import com.boyukliev.base.presentation.executor.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@Module
class AndroidModule() {

    @Provides
    @Singleton
    fun provideThreadExecutor(): ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(): PostExecutionThread {
        return UIThread()
    }

}