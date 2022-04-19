package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.CopiaDao;
import com.example.n1_prog3_javafx.dao.LivrosDao;
import com.example.n1_prog3_javafx.model.Autor;
import com.example.n1_prog3_javafx.model.Copia;
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

public class CopiaController implements Initializable {

    CopiaDao copiaDao = new CopiaDao();
    LivrosDao livrosDao = new LivrosDao();

    @FXML
    private ListView<Copia> LstCopias;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnDeletar;

    @FXML
    private Button BtnGravar;

    @FXML
    private CheckBox CBoxFixo;

    //--//

    @FXML
    private TextField TxtCodigo;


    @FXML
    private ComboBox<Livros> CboLivros;

    //--//

    private void limparTela() {
        TxtCodigo.setText("");
        CboLivros.setValue(null);
    }

    private void limparInterface(){
        TxtCodigo.setText("");
        CboLivros.setValue(null);
        CBoxFixo.setSelected(false);
    }

    private void habilitarInterface(Boolean incluir){
        CboLivros.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstCopias.setDisable(incluir);
        CBoxFixo.setDisable(!incluir);
    }

    private void exibirCopias(){
        Copia copiass = LstCopias.getSelectionModel().getSelectedItem();
        TxtCodigo.setText(copiass.getCodigo().toString());

        CboLivros.setValue(copiass.getlOriginal());

        CBoxFixo.setSelected(copiass.isFixo());
    }

    @FXML
    private void LstAutores_MouseClicked(MouseEvent evento){
        exibirCopias();
    }

    @FXML
    private void LstAutores_KeyPressed(KeyEvent evento){
        exibirCopias();
    }

    @FXML
    protected void BtnAdicionar_Action(ActionEvent evento){
        System.out.println("Adicionar");
        habilitarInterface(true);
        limparInterface();
    }

    @FXML
    protected void BtnDeletar_Action(ActionEvent evento){
        Copia copia = LstCopias.getSelectionModel().getSelectedItem();
        if(copia.isFixo()){
            System.out.println("Cópia fixa.");
            return;
        }
        if (copia==null) return;
        try {
            copiaDao.excluir(copia);
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
        Copia copia = new Copia();

        copia.setlOriginal(CboLivros.getValue());
        copia.setFixo(CBoxFixo.isSelected());

        try {
            copiaDao.gravar(copia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }

    private void atualizarLista() {
        List<Livros> livros;
        List<Copia> copias;

        try {
            livros = livrosDao.listar();
            copias = copiaDao.listar();

        } catch (Exception e) {
            livros = new ArrayList<Livros>();
            copias = new ArrayList<Copia>();

        }
        ObservableList<Copia> copiasOb = FXCollections.observableArrayList(copias);
        LstCopias.setItems(copiasOb);

        ObservableList<Livros> livrosOb = FXCollections.observableArrayList(livros);
        CboLivros.setItems(livrosOb);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarLista();
    }
}
