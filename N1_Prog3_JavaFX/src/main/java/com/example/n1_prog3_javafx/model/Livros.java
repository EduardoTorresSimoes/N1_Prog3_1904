package com.example.n1_prog3_javafx.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class Livros {
    private String edicao;
    private String ano;
    private String nome;

    private List<Genero> genero = new ArrayList<>();
    private List<Autor> autor = new ArrayList<>();


    public Livros(String edicao, String ano, String nome) {
        this.edicao = edicao;
        this.nome = nome;
        this.ano = ano;
    }

    public Livros() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void adicionarAutor(Autor autor){
        this.autor.add(autor);
    }

    public void adicionarGenero(Genero genero){
        this.genero.add(genero);
    }


    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getAno() {
        return ano;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public List<Genero> getGenero() {
        return genero;
    }


    @Override
    public String toString() {
        return nome;
    }

    //---//

}
