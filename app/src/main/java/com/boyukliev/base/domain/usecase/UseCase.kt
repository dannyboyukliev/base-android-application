package com.boyukliev.base.domain.usecase

import com.boyukliev.base.domain.executor.PostExecutionThread
import com.boyukliev.base.domain.executor.ThreadExecutor
import com.boyukliev.base.testing.TestOpen
import io.reactivex.schedulers.Schedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@TestOpen
abstract class UseCase<T, Params> protected constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {

    var params: Params? = null

    protected var disposable = Disposables.empty()

    protected open fun buildUseCaseObservable(): Observable<T> {
        throw UnsupportedOperationException("Override this implementation")
    }

    protected fun buildUseCaseSingle(): Single<T> {
        throw UnsupportedOperationException("Override this implementation")
    }

    protected fun buildUseCaseCompletable(): Completable {
        throw UnsupportedOperationException("Override this implementation")
    }

    fun <S : Observer<T>> execute(useCaseDisposable: S) where S : Disposable {
        this.disposable = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(useCaseDisposable)
    }

    fun execute(useCaseDisposable: DisposableSingleObserver<T>) {
        this.disposable = this.buildUseCaseSingle()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(useCaseDisposable)
    }

    fun execute(useCaseDisposable: DisposableCompletableObserver) {
        this.disposable = this.buildUseCaseCompletable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(useCaseDisposable)
    }

    fun unsubscribe() {
        if (!this.disposable.isDisposed) {
            this.disposable.dispose()
        }
    }

    val isUnsubscribed: Boolean
        get() = this.disposable.isDisposed
}