package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.GeneroDao;
import com.example.n1_prog3_javafx.model.Autor;
import com.example.n1_prog3_javafx.model.Genero;
import com.example.n1_prog3_javafx.model.Livros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GeneroController implements Initializable {

    private GeneroDao generoDao = new GeneroDao();

    @FXML
    private ListView<Genero> LstGeneros;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnDeletar;

    @FXML
    private Button BtnGravar;

    //--//

    @FXML
    private TextField TxtGenero;

    //--//
    private void limparTela() {
        TxtGenero.setText("");
    }

    //--//
    private void limparInterface(){
        TxtGenero.setText("");
    }

    private void habilitarInterface(Boolean incluir){
        TxtGenero.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstGeneros.setDisable(incluir);
    }

    private void exibirGeneros(){
        Genero geneross = LstGeneros.getSelectionModel().getSelectedItem();
        TxtGenero.setText(geneross.getNome());
    }

    @FXML
    private void LstGeneros_MouseClicked(MouseEvent evento){
        exibirGeneros();
    }

    @FXML
    private void LstGeneros_KeyPressed(KeyEvent evento){
        exibirGeneros();
    }

    @FXML
    protected void BtnAdicionar_Action(ActionEvent evento){
        System.out.println("Adicionar");
        habilitarInterface(true);
        limparInterface();
        TxtGenero.requestFocus();
    }

    @FXML
    protected void BtnDeletar_Action(ActionEvent evento){
        Genero genero = LstGeneros.getSelectionModel().getSelectedItem();
        if (genero==null) return;
        try {
            generoDao.excluir(genero);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        limparInterface();
        System.out.println("Excluir");
    }

    @FXML
    protected void BtnGravar_Action(ActionEvent evento){
        System.out.println("Gravar");
        Genero genero = new Genero();
        genero.setNome(TxtGenero.getText());

        try {
            generoDao.gravar(genero);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }

    private void atualizarLista() {
        List<Genero> generos;
        try {
            generos = generoDao.listar();
        } catch (Exception e) {
            generos = new ArrayList<Genero>();
        }
        ObservableList<Genero> generosOb = FXCollections.observableArrayList(generos);
        LstGeneros.setItems(generosOb);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }
}