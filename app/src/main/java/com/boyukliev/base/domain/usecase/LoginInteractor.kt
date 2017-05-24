package com.boyukliev.base.domain.usecase

import com.boyukliev.base.domain.executor.PostExecutionThread
import com.boyukliev.base.domain.executor.ThreadExecutor
import com.boyukliev.base.testing.TestOpen
import io.reactivex.Completable

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@TestOpen
class LoginInteractor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : UseCase<Void, LoginInteractor.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseCompletable(): Completable {
        return super.buildUseCaseCompletable()
    }

    data class Params(var username: String, var password: String)
}