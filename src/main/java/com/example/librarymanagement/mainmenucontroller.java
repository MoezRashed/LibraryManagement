package com.example.librarymanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class mainmenucontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button AddMember;
    @FXML
    private AnchorPane Rootpane7;
    @FXML
    private Button ViewBook;
    @FXML
    private Button ViewEmploye;
    @FXML
    private Button ViewMembers;
    @FXML
    private Button addbook;
    @FXML
    private Button addemployee;
    @FXML
    private Button logout;



    @FXML
    void addnewbook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addbook.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Add Book");
        stage.show();
    }
    @FXML
    void addnewemployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addemployee.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Add Employee");
        stage.show();
    }
    @FXML
    void addnewmember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addmembers.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Add Member");
        stage.show();
    }
    @FXML
    void gobacktologin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.show();
    }
    @FXML
    void viewbook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("bookview.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("View Book");
        stage.show();
    }
    @FXML
    void viewemployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("employeeview.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("View Employee");
        stage.show();
    }
    @FXML
    void viewmem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("memberview.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("View Member");
        stage.show();
    }

}

