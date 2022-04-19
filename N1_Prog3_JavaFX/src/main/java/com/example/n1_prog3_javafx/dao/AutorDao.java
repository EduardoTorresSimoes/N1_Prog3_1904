package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Autor;

import java.util.ArrayList;
import java.util.List;

public class AutorDao implements Dao<Autor> {
    private static List<Autor> autor = new ArrayList<Autor>();

    @Override
    public void gravar(Autor objeto) throws Exception {
        autor.add(objeto);
    }

    @Override
    public List<Autor> listar() throws Exception {
        return autor;
    }

    @Override
    public void excluir(Autor objeto) throws Exception {
        autor.remove(objeto);
    }
}
