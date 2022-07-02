package com.example.librarymanagement;
import CLASSES.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.io.IOException;

public class loginmenucontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button loginbutton;

    @FXML
    private PasswordField password;

    @FXML
    private AnchorPane rootPane1;

    @FXML
    private TextField usename;

    @FXML
    void login(ActionEvent event) throws IOException {

        if(usename.getText().equals(Admin.getUsername()) && password.getText().equals(Admin.getPassword())) {
            Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Main Menu");
            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Wrong Username or Password");
            alert.show();
        }
    }
}
