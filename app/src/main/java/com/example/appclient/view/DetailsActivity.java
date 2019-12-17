package com.example.appclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appclient.R;
import com.example.appclient.callback.PessoaDetailCallback;
import com.example.appclient.contract.DetailContract;
import com.example.appclient.data.Pessoa;
import com.example.appclient.presenter.DetailPresenter;
import com.example.appclient.service.DetailServiceImpl;

public class DetailsActivity extends AppCompatActivity implements DetailContract.DetailUserView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String cpf = intent.getStringExtra(MainActivity.ID_CPF);

        DetailServiceImpl service = new DetailServiceImpl("http://localhost:8080/");
        DetailPresenter presenter = new DetailPresenter(this, service);

        // Load the "Pessoa" objects.
        presenter.loadDetails(cpf);
    }

    @Override
    public void showDetails(Pessoa pessoa) {
        TextView detailName = findViewById(R.id.detailName);
        TextView detailSurname = findViewById(R.id.detailSurname);
        TextView detailCPF = findViewById(R.id.detailCPF);
        TextView detailAge = findViewById(R.id.detailAge);

        detailName.setText(pessoa.getName());
        detailSurname.setText(pessoa.getSobrenome());
        detailCPF.setText(pessoa.getCpf());
        detailAge.setText(pessoa.getIdade());
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
