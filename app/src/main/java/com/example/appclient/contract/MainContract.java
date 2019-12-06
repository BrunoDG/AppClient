package com.example.appclient.contract;

import com.example.appclient.data.Pessoa;

import java.util.List;

public interface MainContract {

    interface MainUserActionListener {
        void refreshButtonClicked();
    }

    interface MainView {
        void showMessage(String msg);
        void showLoading();
        void hideLoading();
        void hideButton();
        void refreshRecyclerView(List<Pessoa> pessoas);
    }

}
