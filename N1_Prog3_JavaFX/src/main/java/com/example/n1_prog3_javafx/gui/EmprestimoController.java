package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.*;
import com.example.n1_prog3_javafx.model.*;
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

public class EmprestimoController implements Initializable {
    private EmprestimoDao emprestimoDao = new EmprestimoDao();
    private LivrosDao livrosDao = new LivrosDao();
    private AlunoDao alunoDao = new AlunoDao();
    private ProfessorDao professorDao = new ProfessorDao();

    @FXML
    private ListView<Emprestimo> LstEmprestimo;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnDeletar;

    @FXML
    private Button BtnGravar;

    //--//

    @FXML
    private ComboBox<Aluno> CboAluno;

    @FXML
    private ComboBox<Professor> CboProfessor;

    @FXML
    private ComboBox<Livros> CboLivro;


    @FXML
    private TextField TxtDevolucao;

    //---//

    private void limparInterface(){
        TxtDevolucao.setText("");
    }

    private void habilitarInterface(Boolean incluir){
        TxtDevolucao.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstEmprestimo.setDisable(incluir);

        CboProfessor.setDisable(!incluir);
        CboLivro.setDisable(!incluir);
        CboAluno.setDisable(!incluir);
    }

    private void exibirEmprestimos(){
        Emprestimo emprestimoss = LstEmprestimo.getSelectionModel().getSelectedItem();
        TxtDevolucao.setText(emprestimoss.getDataDevolucao());
    }

    @FXML
    private void LstEmprestimo_MouseClicked(MouseEvent evento){
        exibirEmprestimos();
    }

    @FXML
    private void LstEmprestimo_KeyPressed(KeyEvent evento){
        exibirEmprestimos();
    }

    @FXML
    protected void BtnAdicionar_Action(ActionEvent evento){
        System.out.println("Adicionar");
        habilitarInterface(true);
        limparInterface();
    }

    @FXML
    protected void BtnDeletar_Action(ActionEvent evento){
        Emprestimo emprestimo = LstEmprestimo.getSelectionModel().getSelectedItem();
        if (emprestimo==null) return;
        try {
            emprestimoDao.excluir(emprestimo);
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
        Emprestimo emprestimo = new Emprestimo();
        //emprestimo.setMatricula(TxtAluno.getText());
        //livro.getGenero().add(CboGenero.getValue());


        //copia.setlOriginal(CboLivros.getValue());

        try {
            emprestimoDao.gravar(emprestimo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }

    private void atualizarLista() {
            List<Emprestimo> emprestimos;
            List<Livros> livros;
            List<Aluno> alunos;
            List<Professor> professores;
        try {
            emprestimos = emprestimoDao.listar();
            livros = livrosDao.listar();
            alunos = alunoDao.listar();
            professores = professorDao.listar();

        } catch (Exception e) {
            emprestimos = new ArrayList<Emprestimo>();
            livros = new ArrayList<Livros>();
            alunos = new ArrayList<Aluno>();
            professores = new ArrayList<Professor>();
        }
        ObservableList<Emprestimo> emprestimosOb = FXCollections.observableArrayList(emprestimos);
        LstEmprestimo.setItems(emprestimosOb);

        /*
        ObservableList<Livros> livrosOb = FXCollections.observableArrayList(livros);
        CboLivros.setItems(livrosOb);

        ObservableList<Aluno> alunoOb = FXCollections.observableArrayList(alunos);
        CboAluno.setItems(alunoOb);

        ObservableList<Professor> professorOb = FXCollections.observableArrayList(professores);
        CboProfessor.setItems(professorOb);

        */
    }

    //=========//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }
}
