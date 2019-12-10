package com.example.appclient.contract;

import com.example.appclient.data.Pessoa;

import java.util.List;

public interface MainContract {

    interface MainUserActionListener {
        void refreshButtonClicked();
        void openDetailsActivity(String cpf);
    }

    interface MainView {
        void showDetailsView(String cpf);
        void showMessage(String msg);
        void showLoading();
        void hideLoading();
        void hideButton();
        void refreshRecyclerView(List<Pessoa> pessoas);
    }

}
