package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.AlunoDao;
import com.example.n1_prog3_javafx.dao.GeneroDao;
import com.example.n1_prog3_javafx.model.Aluno;
import com.example.n1_prog3_javafx.model.Genero;
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

public class AlunoController implements Initializable {

    private AlunoDao alunoDao = new AlunoDao();

    @FXML
    private ListView<Aluno> LstAlunos;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnDeletar;

    @FXML
    private Button BtnGravar;

    //--//

    @FXML
    private TextField TxtAluno;

    //--//
    private void limparTela() {
        TxtAluno.setText("");
    }

    //--//
    private void limparInterface(){
        TxtAluno.setText("");
    }

    private void habilitarInterface(Boolean incluir){
        TxtAluno.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstAlunos.setDisable(incluir);
    }

    private void exibirAlunos(){
        Aluno alunoss = LstAlunos.getSelectionModel().getSelectedItem();
        TxtAluno.setText(alunoss.getMatricula());
    }

    @FXML
    private void LstAlunos_MouseClicked(MouseEvent evento){
        exibirAlunos();
    }

    @FXML
    private void LstAlunos_KeyPressed(KeyEvent evento){
        exibirAlunos();
    }

    @FXML
    protected void BtnAdicionar_Action(ActionEvent evento){
        System.out.println("Adicionar");
        habilitarInterface(true);
        limparInterface();
        TxtAluno.requestFocus();
    }

    @FXML
    protected void BtnDeletar_Action(ActionEvent evento){
        Aluno aluno = LstAlunos.getSelectionModel().getSelectedItem();
        if (aluno==null) return;
        try {
            alunoDao.excluir(aluno);
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
        Aluno aluno = new Aluno();
        aluno.setMatricula(TxtAluno.getText());

        try {
            alunoDao.gravar(aluno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }

    private void atualizarLista() {
        List<Aluno> alunos;
        try {
            alunos = alunoDao.listar();
        } catch (Exception e) {
            alunos = new ArrayList<Aluno>();
        }
        ObservableList<Aluno> alunosOb = FXCollections.observableArrayList(alunos);
        LstAlunos.setItems(alunosOb);
    }
    //-------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }
}