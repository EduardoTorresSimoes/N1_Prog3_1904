package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements Dao<Aluno>{
    private static List<Aluno> aluno = new ArrayList<Aluno>();

    @Override
    public void gravar(Aluno objeto) throws Exception {
        aluno.add(objeto);
    }

    @Override
    public List<Aluno> listar() throws Exception {
        return aluno;
    }

    @Override
    public void excluir(Aluno objeto) throws Exception {
        aluno.remove(objeto);
    }
}
