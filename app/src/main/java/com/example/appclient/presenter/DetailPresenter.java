package com.example.appclient.presenter;

import com.example.appclient.callback.PessoaDetailCallback;
import com.example.appclient.contract.DetailContract;
import com.example.appclient.data.Pessoa;
import com.example.appclient.service.DetailService;

public class DetailPresenter implements DetailContract.DetailsUserActions, PessoaDetailCallback {

    private final DetailContract.DetailUserView view;
    private final DetailService service;

    public DetailPresenter(DetailContract.DetailUserView view, DetailService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void loadDetails(String cpf) {
       service.loadPessoa(cpf, this);
    }

    @Override
    public void onSuccess(Pessoa pessoa) {
        view.showDetails(pessoa);
    }

    @Override
    public void onError(String msg) {
        view.showMessage(msg);
    }
}
