package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements Dao<Professor> {
    private static List<Professor> professor = new ArrayList<Professor>();

    @Override
    public void gravar(Professor objeto) throws Exception {
        professor.add(objeto);
    }

    @Override
    public List<Professor> listar() throws Exception {
        return professor;
    }

    @Override
    public void excluir(Professor objeto) throws Exception {
        professor.remove(objeto);
    }
}
