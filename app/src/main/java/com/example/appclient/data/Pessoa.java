package com.example.appclient.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa implements Parcelable {

    private String name;
    private String sobrenome;
    private int idade;
    private String cpf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(sobrenome);
        dest.writeInt(idade);
        dest.writeString(cpf);
    }

    public static final Parcelable.Creator<Pessoa> CREATOR = new Parcelable.Creator<Pessoa>() {

        @Override
        public Pessoa createFromParcel(Parcel src) {
            return new Pessoa(src);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public Pessoa (Parcel p){
        name = p.readString();
        sobrenome = p.readString();
        idade = p.readInt();
        cpf = p.readString();
    }

    public Pessoa () {}

}
