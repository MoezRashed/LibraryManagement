package com.example.librarymanagement;
import DataBase.Dbconnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class memviewcontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<Member, String> Emailcol;
    @FXML
    private TableColumn<Member, Integer> IDcol;
    @FXML
    private TableView<Member> Memberview;
    @FXML
    private TableColumn<Member, String> Namecol;
    @FXML
    private TableColumn<Member, Double> Phonecol;
    @FXML
    private TextField memid;
    @FXML
    private AnchorPane RootPane;
    @FXML
    private Button backbutton;
    @FXML
    private Button deletebutton;

    String query = null;
    Connection connection =null;
    Statement preparedStatement = null;
    ResultSet resultSet= null;
    ObservableList<Member> list = FXCollections.observableArrayList();
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
    @FXML
    void delete(ActionEvent event) throws SQLException {
        connection = Dbconnect.getConnect();
        Namecol.setCellValueFactory(new PropertyValueFactory<Member ,String >("name"));
        Emailcol.setCellValueFactory(new PropertyValueFactory<Member ,String >("email"));
        Phonecol.setCellValueFactory(new PropertyValueFactory<Member ,Double> ("phone"));
        IDcol.setCellValueFactory(new PropertyValueFactory<Member ,Integer >("ID"));




        list.clear();

        try {
            query = "SELECT * FROM member ";
            connection = Dbconnect.getConnect();
            preparedStatement = connection.createStatement();
            resultSet = preparedStatement.executeQuery(query);
            while(resultSet.next())
            {
                list.add(new Member(resultSet.getString("name"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"),
                                    resultSet.getInt("ID")));
            }
            Memberview.setItems(list);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }

    public void amatedosfeltable() throws SQLException {
        connection = Dbconnect.getConnect();
        Member member = Memberview.getSelectionModel().getSelectedItem();
        query = "SELECT * FROM member ";
        preparedStatement =connection.prepareStatement(query);
        memid.setText(String.valueOf(member.getID()));
        preparedStatement.close();
    }
    public void deletebgd() throws SQLException {

        try {
            connection = Dbconnect.getConnect();
            Member member = (Member)Memberview.getSelectionModel().getSelectedItem();
            query = "DELETE FROM member WHERE id = ?";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1 , String.valueOf(member.getID()));
            pre.executeUpdate();
            preparedStatement.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Member Deleted Successfully! Refresh to see your current members");
            alert.show();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please choose member to delete!");
            alert.show();
        }
    }

}
