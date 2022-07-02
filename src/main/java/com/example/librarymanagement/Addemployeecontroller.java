package com.example.librarymanagement;

import DataBase.Dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Addemployeecontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button cancelbutton;
    @FXML
    private TextField email;
    @FXML
    private TextField employeeid;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private AnchorPane rootpane2;
    @FXML
    private TextField salary;
    @FXML
    private Button savebutton;
    String query = null;
    Connection connection =null;
    PreparedStatement preparedStatement = null;

    @FXML
    void cancelemployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }

    @FXML
    void saveemployee(ActionEvent event) {
        connection = Dbconnect.getConnect();
        String Name = name.getText();
        String Phone = phone.getText();
        String Email = email.getText();
        String Employeeid = employeeid.getText();
        String Salary = salary.getText();
        if (Name.isEmpty() || Phone.isEmpty() || Email.isEmpty()||Employeeid.isEmpty()||Salary.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("There is an empty field!");
            alert.showAndWait();
            return;
        }
        else{
            query = "INSERT INTO employee ( EmployeeID , salary , name , email , phone )" +
                    "VALUES(?, ?, ?, ?, ?)";
            // "INSERT INTO `library`.`book` (`ISBN`,`BookName`,`author`,`price`) VALUES(<{ISBN: }>,<{BookName: }>,<{author: }>,<{price: }>);"
            //"INSERT INTO employee ( EmployeeID , salary , name , email , phone )" +
            //"VALUES(?, ?, ?, ?, ?)";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(Employeeid));
                preparedStatement.setInt(2, Integer.parseInt(Salary));
                preparedStatement.setString(3, Name);
                preparedStatement.setString(4, Email);
                preparedStatement.setDouble(5, Double.parseDouble(Phone));
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Employee Added Successfully!");
                alert.show();
                email.clear();
                employeeid.clear();
                name.clear();
                phone.clear();
                salary.clear();
                // preparedStatement.executeUpdate();

            }
            catch (SQLException ex) {
                Logger.getLogger(AddbookController.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (Exception e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("WRONG DATA TYPE!");
                alert.show();
            }
        }
    }

}

