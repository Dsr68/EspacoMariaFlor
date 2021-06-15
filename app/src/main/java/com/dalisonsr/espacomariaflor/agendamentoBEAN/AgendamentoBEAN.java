package com.dalisonsr.espacomariaflor.agendamentoBEAN;

import android.widget.Spinner;

public class AgendamentoBEAN {
    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String data;
    private String hora;
    private int mao;
    private int pe;
    private int manutencao;
    private int plastica;
    private int fibra;
    private int gelmoldado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    public int getMao() {
        return mao;
    }

    public void setMao(int mao) {
        this.mao = mao;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getManutencao() {
        return manutencao;
    }

    public void setManutencao(int manutencao) {
        this.manutencao = manutencao;
    }

    public int getPlastica() {
        return plastica;
    }

    public void setPlastica(int plastica) {
        this.plastica = plastica;
    }

    public int getFibra() {
        return fibra;
    }

    public void setFibra(int fibra) {
        this.fibra = fibra;
    }

    public int getGelmoldado() {
        return gelmoldado;
    }

    public void setGelmoldado(int gelmoldado) {
        this.gelmoldado = gelmoldado;
    }

}
