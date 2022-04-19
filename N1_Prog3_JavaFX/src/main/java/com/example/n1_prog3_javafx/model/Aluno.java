package com.example.n1_prog3_javafx.model;

public class Aluno extends Usuario{
    public Aluno(String matricula) {
        this.prazoDevolucao = 5;
        this.matricula = matricula;
    }

    public Aluno() {

    }

    @Override
    public String toString() {
        return "A-" + matricula;
    }
}
