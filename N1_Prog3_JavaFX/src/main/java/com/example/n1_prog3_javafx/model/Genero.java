package com.example.n1_prog3_javafx.model;

import java.util.ArrayList;
import java.util.List;

public class Genero {
    public String nome;
    public static List<Genero> listaGeneros = new ArrayList<>();

    public Genero(){

    }

    public Genero(String nome) {
        this.nome = nome;
        listaGeneros.add(this);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
