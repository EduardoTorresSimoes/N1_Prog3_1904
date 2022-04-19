package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao implements Dao<Emprestimo> {
    private static List<Emprestimo> emprestimo = new ArrayList<Emprestimo>();

    @Override
    public void gravar(Emprestimo objeto) throws Exception {
        emprestimo.add(objeto);
    }

    @Override
    public List<Emprestimo> listar() throws Exception {
        return emprestimo;
    }

    @Override
    public void excluir(Emprestimo objeto) throws Exception {
        emprestimo.remove(objeto);
    }
}
