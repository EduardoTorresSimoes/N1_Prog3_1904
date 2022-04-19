package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.AutorDao;
import com.example.n1_prog3_javafx.model.Autor;

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

public class AutorController implements Initializable {
    private AutorDao autorDao = new AutorDao();

    @FXML
    private ListView<Autor> LstAutores;

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
    private TextField TxtSobrenome;

    //--//
    private void limparTela() {
        TxtNome.setText("");
        TxtSobrenome.setText("");
    }

    //--//
    private void limparInterface(){
        TxtNome.setText("");
        TxtSobrenome.setText("");
    }

    private void habilitarInterface(Boolean incluir){
        TxtNome.setDisable(!incluir);
        TxtSobrenome.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstAutores.setDisable(incluir);
    }

    private void exibirAutores(){
        Autor autorr = LstAutores.getSelectionModel().getSelectedItem();
        TxtNome.setText(autorr.getNome());
        TxtSobrenome.setText(autorr.getSobrenome());
    }

    @FXML
    private void LstAutores_MouseClicked(MouseEvent evento){
        exibirAutores();
    }

    @FXML
    private void LstAutores_KeyPressed(KeyEvent evento){
        exibirAutores();
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
        Autor autor = LstAutores.getSelectionModel().getSelectedItem();
        if (autor==null) return;
        try {
            autorDao.excluir(autor);
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
        Autor autor = new Autor();
        autor.setNome(TxtNome.getText());
        autor.setSobrenome(TxtSobrenome.getText());

        try {
            autorDao.gravar(autor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }

    private void atualizarLista() {
        List<Autor> autores;
        try {
            autores = autorDao.listar();
        } catch (Exception e) {
            autores = new ArrayList<Autor>();
        }
        ObservableList<Autor> autoresOb = FXCollections.observableArrayList(autores);
        LstAutores.setItems(autoresOb);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }
}
