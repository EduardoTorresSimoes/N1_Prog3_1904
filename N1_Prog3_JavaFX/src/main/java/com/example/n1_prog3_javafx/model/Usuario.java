package com.example.n1_prog3_javafx.model;

public class Usuario {
    public Integer prazoDevolucao;
    public String matricula;

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return matricula;
    }
}
