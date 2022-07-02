package com.example.librarymanagement;

import CLASSES.Books;
import DataBase.Dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddbookController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField ISBN;
    @FXML
    private TextField author;
    @FXML
    private TextField Price;
    @FXML
    private TextField BookName;
    @FXML
    private Button add;
    @FXML
    private Button cancelaction;

    String query = null;
    Connection connection =null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;
    Books books = null;

    @FXML
    private  void save (ActionEvent event){
        connection = Dbconnect.getConnect();
        String isbn = ISBN.getText();
        String Author = author.getText();
        String price = Price.getText();
        String bookname = BookName.getText();
        if (isbn.isEmpty() || Author.isEmpty() || price.isEmpty()||bookname.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("There is an empty field!");
            alert.showAndWait();
            return;
        }
        else{
            query = "INSERT INTO book ( ISBN , BookName , author , price )"+
                    "VALUES (?, ?, ?, ?)";
           // "INSERT INTO `library`.`book` (`ISBN`,`BookName`,`author`,`price`) VALUES(<{ISBN: }>,<{BookName: }>,<{author: }>,<{price: }>);"

            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, isbn);
                preparedStatement.setString(2, bookname);
                preparedStatement.setString(3, Author);
                preparedStatement.setDouble(4, Double.parseDouble(price));
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Book Added Successfully!");
                alert.show();
               // preparedStatement.executeUpdate();
                ISBN.clear();
                author.clear();
                Price.clear();
                BookName.clear();

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
    @FXML
    private  void cancel (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
}
