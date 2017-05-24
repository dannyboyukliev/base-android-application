package com.boyukliev.base.presentation.ui.login

import com.boyukliev.base.presentation.ui.base.BaseNavigator
import com.boyukliev.base.presentation.ui.base.BasePresenter
import com.boyukliev.base.presentation.ui.base.BaseView

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
interface LoginActivityContract {
    interface View: BaseView

    interface Navigator: BaseNavigator

    abstract class Presenter: BasePresenter<View, Navigator>() {

    }
}