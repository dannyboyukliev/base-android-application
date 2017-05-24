package com.boyukliev.base.presentation.ui.login;

import com.boyukliev.base.domain.usecase.LoginInteractor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created with <3 by Boyukliev on 24.5.2017 г..
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginActivityPresenterTest {

    private LoginActivityPresenter presenter;
    private LoginActivityPresenter.LoginCompletableObserver loginCompletableObserver;

    @Mock private LoginActivityContract.View loginViewMock;
    @Mock private LoginActivityContract.Navigator loginViewNavigatorMock;
    @Mock private LoginInteractor loginInteractorMock;

    @Before
    public void setUp() {
        presenter = new LoginActivityPresenter(loginInteractorMock);
        presenter.bindView(loginViewMock);
        presenter.bindNavigator(loginViewNavigatorMock);
        loginCompletableObserver = presenter.new LoginCompletableObserver();
    }

    @Test
    public void testLoginCompletableObserverOnComplete() {
        loginCompletableObserver.onComplete();


    }

    @Test
    public void testLoginCompletableObserverOnError() {
        final Exception FAKE_EXCEPTION = new Exception();

        loginCompletableObserver.onError(FAKE_EXCEPTION);

        verify(loginViewMock).displayError(FAKE_EXCEPTION.getLocalizedMessage());
    }
}
