package com.boyukliev.base.presentation.ui.login

import com.boyukliev.base.domain.usecase.LoginInteractor
import io.reactivex.observers.DisposableCompletableObserver

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
class LoginActivityPresenter(private var loginInteractor: LoginInteractor): LoginActivityContract.Presenter() {


    inner class LoginCompletableObserver: DisposableCompletableObserver() {
        override fun onComplete() {

        }

        override fun onError(e: Throwable?) {
            if (e != null) {
                view?.displayError(e.localizedMessage!!)
            } else {
                view?.displayError()
            }
        }
    }
}