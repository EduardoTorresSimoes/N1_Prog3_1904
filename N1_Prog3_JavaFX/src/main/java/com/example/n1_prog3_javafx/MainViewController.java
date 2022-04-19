package com.example.n1_prog3_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainViewController {


    @FXML
    protected void BtnCadLivro_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Livros");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadGenero_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("genero-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Genero");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadAutor_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("autor-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Autor");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadCopias_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("copia-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Copias");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }


    }

    @FXML
    protected void BtnCadAlunos_Action() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("aluno-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Aluno");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadProfessor_Action() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("professor-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Professor");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadEmprestimo_Action() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("emprestimo-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Emprestimo");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
