package com.example.appclient.service;

import com.example.appclient.callback.PessoaDetailCallback;
import com.example.appclient.data.Pessoa;
import com.example.appclient.repository.PessoasRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailServiceImpl implements DetailService {

    private PessoasRepository repo;

    public DetailServiceImpl(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(PessoasRepository.class);
    }

    @Override
    public void loadPessoa(String cpf, final PessoaDetailCallback callback) {
        repo.getPessoa(cpf).enqueue(new Callback<Pessoa>() {
            @Override
            public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
                if (response.body() != null) {
                    if (response.code() >= 200 && response.code() < 300) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onError(response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<Pessoa> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
