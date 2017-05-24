package com.boyukliev.base.presentation.executor

import com.boyukliev.base.domain.executor.ThreadExecutor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
class JobExecutor : ThreadExecutor {

    internal var threadPoolExecutor: ThreadPoolExecutor

    init {
        val workQueue = LinkedBlockingQueue<Runnable>()
        this.threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT, workQueue, JobThreadFactory())
    }

    override fun execute(runnable: Runnable) {
        this.threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, THREAD_NAME + counter++)
        }

        companion object {
            internal val THREAD_NAME = "android_"
        }
    }

    companion object {

        internal val INITIAL_POOL_SIZE = 3
        internal val MAX_POOL_SIZE = 5
        internal val KEEP_ALIVE_TIME = 10
        internal val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }

}