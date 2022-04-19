package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.AutorDao;
import com.example.n1_prog3_javafx.dao.GeneroDao;
import com.example.n1_prog3_javafx.dao.LivrosDao;
import com.example.n1_prog3_javafx.model.Autor;
import com.example.n1_prog3_javafx.model.Genero;
import com.example.n1_prog3_javafx.model.Livros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private LivrosDao livrosDao = new LivrosDao();
    private GeneroDao generoDao = new GeneroDao();
    private AutorDao autorDao = new AutorDao();

    @FXML
    private ListView<Livros> LstLivros;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnDeletar;

    @FXML
    private Button BtnGravar;

    //--//

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtAno;

    @FXML
    private TextField TxtEdicao;

    @FXML
    private ComboBox<Genero> CboGenero;

    @FXML
    private ComboBox<Autor> CboAutor;
    //--//

    private void limparInterface(){
        TxtAno.setText("");
        TxtNome.setText("");
        TxtEdicao.setText("");
        CboGenero.setValue(null);
        CboAutor.setValue(null);
    }

    private void habilitarInterface(Boolean incluir){
        TxtAno.setDisable(!incluir);
        TxtNome.setDisable(!incluir);
        TxtEdicao.setDisable(!incluir);
        CboGenero.setDisable(!incluir);
        CboAutor.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstLivros.setDisable(incluir);
    }

    private void exibirLivros(){
        Livros livross = LstLivros.getSelectionModel().getSelectedItem();
        TxtNome.setText(livross.getNome());
        TxtAno.setText(livross.getAno());
        TxtEdicao.setText(livross.getEdicao());

        //TODO: Ajeitar isso depois.
        //CboGenero.setValue(livross.getGenero());
        //CboAutor.setValue(livross.getAutor());

        CboAutor.setValue(livross.getAutorEscolhido());
        CboGenero.setValue(livross.getGeneroEscolhido());

        //CboLivros.setValue(copiass.getlOriginal());
    }

    @FXML
    private void LstLivros_MouseClicked(MouseEvent evento){
        exibirLivros();
    }

    @FXML
    private void LstLivros_KeyPressed(KeyEvent evento){
        exibirLivros();
    }

    @FXML
    protected void BtnAdicionar_Action(ActionEvent evento){
        System.out.println("Adicionar");
        habilitarInterface(true);
        limparInterface();
        TxtNome.requestFocus();
    }

    @FXML
    protected void BtnDeletar_Action(ActionEvent evento){
        Livros livro = LstLivros.getSelectionModel().getSelectedItem();
        if (livro==null) return;
        try {
            livrosDao.excluir(livro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        limparInterface();
        System.out.println("Excluir");
    }

    @FXML
    protected void BtnGravar_Action(ActionEvent evento) throws Exception {
        System.out.println("Gravar");
        Livros livro = new Livros();
        livro.setNome(TxtNome.getText());
        livro.setAno(TxtAno.getText());
        livro.setEdicao(TxtEdicao.getText());

        //livro.getAutor().add(CboAutor.getValue());
        //livro.getGenero().add(CboGenero.getValue());

        livro.setAutorEscolhido(CboAutor.getValue());
        livro.setGeneroEscolhido(CboGenero.getValue());

        try {
            livrosDao.gravar(livro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        limparInterface();
        habilitarInterface(false);
    }

    private void atualizarLista() {
        List<Livros> livros;
        List<Genero> generos;
        List<Autor> autores;
        try {
            livros = livrosDao.listar();
            generos = generoDao.listar();
            autores = autorDao.listar();
        } catch (Exception e) {
            livros = new ArrayList<Livros>();
            autores = new ArrayList<Autor>();
            generos = new ArrayList<Genero>();
        }
        ObservableList<Livros> livrosOb = FXCollections.observableArrayList(livros);
        LstLivros.setItems(livrosOb);

        ObservableList<Genero> generosOb = FXCollections.observableArrayList(generos);
        CboGenero.setItems(generosOb);

        ObservableList<Autor> autoresOb = FXCollections.observableArrayList(autores);
        CboAutor.setItems(autoresOb);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }

}