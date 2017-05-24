package com.boyukliev.base.presentation.ui.login

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife

import com.boyukliev.base.R
import com.boyukliev.base.presentation.ui.base.BaseActivity
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginActivityComponent>(), LoginActivityContract.View, LoginActivityContract.Navigator {

    @BindView(R.id.toolbar) lateinit var toolbar : Toolbar
    @BindView(R.id.fab) lateinit var fab : FloatingActionButton

    @Inject lateinit var presenter: LoginActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ButterKnife.bind(this)

        setSupportActionBar(toolbar)

        injectActivityComponent()

        presenter.bindView(this)
        presenter.bindNavigator(this)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_login, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        when (id) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun injectActivityComponent() {
        activityComponent = applicationComponent?.plus(LoginActivityModule(this))
        activityComponent?.inject(this)
    }
}
