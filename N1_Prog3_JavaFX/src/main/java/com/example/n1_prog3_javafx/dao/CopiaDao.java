package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Copia;

import java.util.ArrayList;
import java.util.List;

public class CopiaDao implements Dao<Copia>{
    private static List<Copia> copia = new ArrayList<Copia>();

    @Override
    public void gravar(Copia objeto) throws Exception {
        copia.add(objeto);
    }

    @Override
    public List<Copia> listar() throws Exception {
        return copia;
    }

    @Override
    public void excluir(Copia objeto) throws Exception {
        copia.remove(objeto);
    }
}
