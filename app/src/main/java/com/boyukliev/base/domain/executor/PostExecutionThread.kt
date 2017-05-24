package com.boyukliev.base.domain.executor

import io.reactivex.Scheduler

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}