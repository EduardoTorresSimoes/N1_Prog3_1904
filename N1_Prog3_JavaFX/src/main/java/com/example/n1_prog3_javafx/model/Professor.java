package com.example.n1_prog3_javafx.model;

public class Professor extends Usuario{
    public Professor(String matricula) {
        this.prazoDevolucao = 30;
        this.matricula = matricula;
    }

    public Professor() {

    }

    @Override
    public String toString() {
        return "P-" + matricula;
    }
}
