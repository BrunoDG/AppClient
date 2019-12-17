package com.example.appclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appclient.R;
import com.example.appclient.contract.DetailContract;
import com.example.appclient.data.Pessoa;
import com.example.appclient.presenter.DetailPresenter;
import com.example.appclient.service.DetailServiceImpl;

public class DetailsActivity extends AppCompatActivity implements DetailContract.DetailUserView {

    private TextView detailName;
    private TextView detailSurname;
    private TextView detailCPF;
    private TextView detailAge;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String cpf = intent.getStringExtra(MainActivity.ID_CPF);

        DetailServiceImpl service = new DetailServiceImpl(getString(R.string.main_url));
        DetailPresenter presenter = new DetailPresenter(this, service);

        // Load the "Pessoa" objects.
        presenter.loadDetails(cpf);

        detailName = findViewById(R.id.detailName);
        detailSurname = findViewById(R.id.detailSurname);
        detailCPF = findViewById(R.id.detailCPF);
        detailAge = findViewById(R.id.detailAge);
    }

    @Override
    public void showDetails(Pessoa pessoa) {
        String age = String.valueOf(pessoa.getIdade());

        detailName.setText(pessoa.getName());
        detailSurname.setText(pessoa.getSobrenome());
        detailCPF.setText(pessoa.getCpf());
        detailAge.setText(age);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
