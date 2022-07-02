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

public class Addmembercontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button cancelbutton;

    @FXML
    private TextField email;

    @FXML
    private TextField memberid;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private AnchorPane rootpane3;

    @FXML
    private Button savebutton;
    String query = null;
    Connection connection =null;
    PreparedStatement preparedStatement = null;
    @FXML
    void cancelmember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Main Menu");
        stage.show();
    }

    @FXML
    void savemember(ActionEvent event) {
        connection = Dbconnect.getConnect();
        String Name = name.getText();
        String Phone = phone.getText();
        String Email = email.getText();
        String memid = memberid.getText();

        if (Name.isEmpty() || Phone.isEmpty() || Email.isEmpty()||memid.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("There is an empty field!");
            alert.showAndWait();
            return;
        }
        else{
            query = "INSERT INTO member ( name , email , phone , id )"+
                    "VALUES(?, ?, ?, ?)";
            // "INSERT INTO `library`.`book` (`ISBN`,`BookName`,`author`,`price`) VALUES(<{ISBN: }>,<{BookName: }>,<{author: }>,<{price: }>);"
            //"INSERT INTO employee ( EmployeeID , salary , name , email , phone )" +
            //"VALUES(?, ?, ?, ?, ?)";

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, Name);
                preparedStatement.setString(2, Email);
                preparedStatement.setString(3, Phone);
                preparedStatement.setInt(4, Integer.parseInt(memid));
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Member Added Successfully!");
                alert.show();
                email.clear();
                name.clear();
                phone.clear();
                memberid.clear();
                // preparedStatement.executeUpdate();

            } catch (SQLException ex) {
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
