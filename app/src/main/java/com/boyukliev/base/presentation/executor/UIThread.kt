package com.boyukliev.base.presentation.executor

import com.boyukliev.base.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
class UIThread: PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}