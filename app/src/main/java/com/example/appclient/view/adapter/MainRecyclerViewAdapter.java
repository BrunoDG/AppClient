package com.example.appclient.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appclient.R;
import com.example.appclient.data.Pessoa;
import com.example.appclient.view.RecyclerClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private final RecyclerClickListener listener;
    private List<Pessoa> pessoasDataSet;

    public List<Pessoa> getPessoasDataSet() {
        return pessoasDataSet;
    }

    public void setPessoasDataSet(List<Pessoa> pessoasDataSet) {
        this.pessoasDataSet = pessoasDataSet;
        this.notifyDataSetChanged();
    }

    public MainRecyclerViewAdapter(RecyclerClickListener listener){
        this.listener = listener;
        this.setPessoasDataSet(new ArrayList<Pessoa>());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pessoa pessoa = pessoasDataSet.get(position);

        holder.name.setText(pessoa.getName());
        holder.lastName.setText(pessoa.getSobrenome());
        holder.age.setText(String.valueOf(pessoa.getIdade()));
        holder.cpf.setText(pessoa.getCpf());
    }

    @Override
    public int getItemCount() {
        return pessoasDataSet.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView lastName;
        TextView age;
        TextView cpf;
        Button btn;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtName);
            lastName = itemView.findViewById(R.id.txtLastName);
            age = itemView.findViewById(R.id.txtAge);
            cpf = itemView.findViewById(R.id.txtCPF);
            btn = itemView.findViewById(R.id.details_btn);

            btn.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getLayoutPosition());
        }
    }
}
