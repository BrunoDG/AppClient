package com.example.appclient.callback;

import com.example.appclient.data.Pessoa;

public interface PessoaDetailCallback {
    void onSuccess(Pessoa pessoa);
    void onError(String erro);
}
