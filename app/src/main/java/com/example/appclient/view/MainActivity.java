package com.example.appclient.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.appclient.R;
import com.example.appclient.contract.MainContract;
import com.example.appclient.data.Pessoa;
import com.example.appclient.presenter.MainPresenter;
import com.example.appclient.service.MainService;
import com.example.appclient.service.MainServiceImpl;
import com.example.appclient.view.adapter.MainRecyclerViewAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private RecyclerView listaPessoas;
    private MainRecyclerViewAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private ProgressBar progressBar;
    private Button button;

    private MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainService service = new MainServiceImpl(getString(R.string.main_url));
        presenter = new MainPresenter(this, service);

        listaPessoas = findViewById(R.id.main_recycler);
        refreshLayout = findViewById(R.id.refresh_layout);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.load_btn);

        adapter = new MainRecyclerViewAdapter();
        listaPessoas.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaPessoas.setLayoutManager(layoutManager);

        refreshLayout.setOnRefreshListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showButton() {
        button.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideButton() {
        button.setVisibility(View.INVISIBLE);
    }

    @Override
    public void refreshRecyclerView(List<Pessoa> pessoas) {
        adapter.setPessoasDataSet(pessoas);
    }

    @Override
    public void onRefresh() {
        presenter.refreshButtonClicked();
    }

    @Override
    public void onClick(View v) {
        presenter.refreshButtonClicked();
    }
}
