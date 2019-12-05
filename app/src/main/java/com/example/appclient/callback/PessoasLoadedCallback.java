package com.example.appclient.callback;

import com.example.appclient.data.Pessoa;

import java.util.List;

public interface PessoasLoadedCallback {
    void onSuccess(List<Pessoa> pessoas);
    void onError(String error);
}
