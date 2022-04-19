package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.ProfessorDao;
import com.example.n1_prog3_javafx.model.Professor;
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

public class ProfessorController implements Initializable {

    private ProfessorDao professorDao = new ProfessorDao();

    @FXML
    private ListView<Professor> LstProfessor;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnDeletar;

    @FXML
    private Button BtnGravar;

    //--//

    @FXML
    private TextField TxtProfessor;

    //--//
    private void limparTela() {
        TxtProfessor.setText("");
    }

    //--//
    private void limparInterface(){
        TxtProfessor.setText("");
    }

    private void habilitarInterface(Boolean incluir){
        TxtProfessor.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstProfessor.setDisable(incluir);
    }

    private void exibirProfessor(){
        Professor professorr = LstProfessor.getSelectionModel().getSelectedItem();
        TxtProfessor.setText(professorr.getMatricula());
    }

    @FXML
    private void LstProfessor_MouseClicked(MouseEvent evento){
        exibirProfessor();
    }

    @FXML
    private void LstProfessor_KeyPressed(KeyEvent evento){
        exibirProfessor();
    }

    @FXML
    protected void BtnAdicionar_Action(ActionEvent evento){
        System.out.println("Adicionar");
        habilitarInterface(true);
        limparInterface();
        TxtProfessor.requestFocus();
    }

    @FXML
    protected void BtnDeletar_Action(ActionEvent evento){
        Professor professor = LstProfessor.getSelectionModel().getSelectedItem();
        if (professor==null) return;
        try {
            professorDao.excluir(professor);
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
        Professor professor = new Professor();
        professor.setMatricula(TxtProfessor.getText());

        try {
            professorDao.gravar(professor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }

    private void atualizarLista() {
        List<Professor> professor;
        try {
            professor = professorDao.listar();
        } catch (Exception e) {
            professor = new ArrayList<Professor>();
        }
        ObservableList<Professor> professorOb = FXCollections.observableArrayList(professor);
        LstProfessor.setItems(professorOb);
    }
    //-------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }


}
