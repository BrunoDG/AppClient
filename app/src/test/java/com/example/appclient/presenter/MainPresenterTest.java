package com.example.appclient.presenter;

import com.example.appclient.callback.PessoasLoadedCallback;
import com.example.appclient.contract.MainContract;
import com.example.appclient.data.Pessoa;
import com.example.appclient.service.MainService;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterTest {

    @Mock
    MainContract.MainView view;

    @Mock
    MainService service;

    @Mock
    List<Pessoa> pessoas;

    @InjectMocks
    MainPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldShowLoadingAndHideButtonWhenLoadingPessoas() {

        presenter.refreshButtonClicked();

        Mockito.verify(view).showLoading();
        Mockito.verify(view).hideButton();
        Mockito.verify(service).loadPessoas(presenter);
    }

    @Test
    public void shouldHideLoadingWhenRefreshRecyclerView() {
        presenter.onSuccess(pessoas);

        Mockito.verify(view).refreshRecyclerView(pessoas);
        Mockito.verify(view).hideLoading();
    }

    @Test
    public void shouldErrorOccurWhenRefreshRecyclerViewFails() {

        presenter.onError(anyString());

        Mockito.verify(view).showMessage(anyString());
        Mockito.verify(view).hideLoading();
    }

    @Test
    public void testMetodo() {
        when(service.soma(anyInt(), anyInt())).thenReturn(100);

        presenter.metodo(10000, 100000);

        verify(service).ok();

        when(service.soma(anyInt(), anyInt())).thenReturn(0);

        presenter.metodo(10000, 100000);

        verify(service).notOk();
    }
}