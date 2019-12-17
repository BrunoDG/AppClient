package com.example.appclient.contract;

import com.example.appclient.data.Pessoa;

public interface DetailContract {

    interface DetailUserView {
        void showDetails(Pessoa pessoa);
        void showMessage(String msg);
    }

    interface DetailsUserActions {
        void loadDetails(String cpf);
    }
}
