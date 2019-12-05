package com.example.appclient.presenter;

import com.example.appclient.callback.PessoasLoadedCallback;
import com.example.appclient.contract.MainContract;
import com.example.appclient.data.Pessoa;
import com.example.appclient.service.MainService;

import java.util.List;

public class MainPresenter implements MainContract.MainUserActionListener, PessoasLoadedCallback {

    private final MainContract.MainView view;
    private final MainService service;

    public MainPresenter(MainContract.MainView view, MainService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void refreshButtonClicked() {
        service.loadPessoas(this);
    }

    @Override
    public void onSuccess(List<Pessoa> pessoas) {
        view.refreshRecyclerView(pessoas);
    }

    @Override
    public void onError(String error) {
        view.showMessage(error);
    }
}
