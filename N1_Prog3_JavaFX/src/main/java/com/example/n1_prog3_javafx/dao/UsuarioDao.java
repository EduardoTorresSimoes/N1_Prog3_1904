package com.example.n1_prog3_javafx.dao;

import com.example.n1_prog3_javafx.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements Dao<Usuario>{
    private List<Usuario> usuario = new ArrayList<Usuario>();

    @Override
    public void gravar(Usuario objeto) throws Exception {
        usuario.add(objeto);
    }

    @Override
    public List<Usuario> listar() throws Exception {
        return usuario;
    }

    @Override
    public void excluir(Usuario objeto) throws Exception {
        usuario.remove(objeto);
    }
}
