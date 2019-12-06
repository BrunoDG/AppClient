package com.example.appclient.service;

import com.example.appclient.callback.PessoasLoadedCallback;

public interface MainService {
    void loadPessoas(PessoasLoadedCallback callback);

    void ok();
    void notOk();
    int soma(int x, int y);
}
