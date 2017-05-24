package com.boyukliev.base.presentation.ui.base

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
abstract class BasePresenter<V: BaseView, N: BaseNavigator> {

    var view: V? = null
        private set
        get
    var navigator: N? = null
        private set
        get

    fun bindView(view: V) {
        this.view = view
    }

    fun bindNavigator(navigator: N) {
        this.navigator = navigator
    }

    fun unbindView() {
        this.view = null
    }

    fun unbindNavigator() {
        this.navigator = null
    }

    fun unbind() {
        unbindView()
        unbindNavigator()
    }
}