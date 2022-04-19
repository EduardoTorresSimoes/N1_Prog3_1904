package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Genero;

import java.util.ArrayList;
import java.util.List;

public class GeneroDao implements Dao<Genero> {
    private static List<Genero> genero = new ArrayList<Genero>();

    @Override
    public void gravar(Genero objeto) throws Exception {
        genero.add(objeto);
        System.out.println(genero.get(0));
    }

    @Override
    public List<Genero> listar() throws Exception {
        return genero;
    }

    @Override
    public void excluir(Genero objeto) throws Exception {
        genero.remove(objeto);
    }
}
