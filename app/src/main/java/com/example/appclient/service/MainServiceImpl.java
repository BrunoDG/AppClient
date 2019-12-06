package com.example.appclient.service;

import com.example.appclient.callback.PessoasLoadedCallback;
import com.example.appclient.data.Pessoa;
import com.example.appclient.repository.MainRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainServiceImpl implements MainService {

    private MainRepository repository;

    public MainServiceImpl(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repository = retrofit.create(MainRepository.class);
    }




    @Override
    public void loadPessoas(final PessoasLoadedCallback callback) {
        repository.getPessoas().enqueue(new Callback<List<Pessoa>>() {
            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> response) {
                if (response.body() != null && !response.body().isEmpty()) {

                    if(response.code() >= 200 && response.code() < 300) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onError(response.message());
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void ok() {

    }

    @Override
    public void notOk() {

    }

    @Override
    public int soma(int x, int y) {
        return  x + y;
    }
}
