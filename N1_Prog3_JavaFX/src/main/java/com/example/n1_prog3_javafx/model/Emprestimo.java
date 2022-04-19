package com.example.n1_prog3_javafx.model;

public class Emprestimo {
    public String dataDevolucao;
    public String dataEmprestimo;

    public Emprestimo(String dataDevolucao, String dataEmprestimo) {
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Emprestimo() {

    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
}
