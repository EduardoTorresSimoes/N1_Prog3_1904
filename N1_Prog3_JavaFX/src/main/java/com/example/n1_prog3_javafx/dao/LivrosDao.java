package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Livros;

import java.util.ArrayList;
import java.util.List;

public class LivrosDao implements Dao<Livros>{
    private static List<Livros> livros = new ArrayList<Livros>();

    @Override
    public void gravar(Livros objeto) throws Exception {
        livros.add(objeto);
    }

    @Override
    public List<Livros> listar() throws Exception {
        return livros;
    }

    @Override
    public void excluir(Livros objeto) throws Exception {
        livros.remove(objeto);
    }
}
