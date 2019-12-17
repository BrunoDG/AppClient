package com.example.appclient.repository;

import com.example.appclient.data.Pessoa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PessoasRepository {
    @GET("pessoas")
    Call<List<Pessoa>> getPessoas();

    @GET("pessoa/{id}")
    Call<Pessoa> getPessoa(@Path("id") String cpf);
}
