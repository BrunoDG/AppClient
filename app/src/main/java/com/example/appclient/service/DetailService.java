package com.example.appclient.service;

import com.example.appclient.callback.PessoaDetailCallback;

public interface DetailService {
    void loadPessoa(String cpf, PessoaDetailCallback callback);
}
