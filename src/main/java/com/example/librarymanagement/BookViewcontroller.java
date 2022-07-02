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
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class BookViewcontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane Rootpane5;
    @FXML
    private TableColumn<Books,String> authorcol;
    @FXML
    private Button backbutton;
    @FXML
    private TableColumn<Books,String> booknamecol;
    @FXML
    private TableView<Books> bookview;
    @FXML
    private Button deletebutton;
    @FXML
    private TableColumn<Books,String> isbncol;
    @FXML
    private TextField isbntext;
    @FXML
    private TableColumn<Books, Double> pricecol;
    String query = null;
    Connection connection =null;
    Statement preparedStatement = null;
    ResultSet resultSet= null;
    Books books = null;
    ObservableList<Books> list = FXCollections.observableArrayList();

    @FXML
    void deletebook() throws SQLException {
        connection = Dbconnect.getConnect();
        isbncol.setCellValueFactory(new PropertyValueFactory<Books,String>("ISBN"));
        booknamecol.setCellValueFactory(new PropertyValueFactory<Books,String>("BookName"));
        authorcol.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        pricecol.setCellValueFactory(new PropertyValueFactory<Books,Double>("price"));

        list.clear();

        try {
            query = "SELECT * FROM book ";
            connection = Dbconnect.getConnect();
            preparedStatement = connection.createStatement();
            resultSet = preparedStatement.executeQuery(query);
            if (!resultSet.next())
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have no books!");
                alert.show();
            }
            while(resultSet.next())
            {
                list.add(new Books(  resultSet.getString("ISBN"),
                                     resultSet.getString("BookName"),
                                     resultSet.getString("author"),
                                     resultSet.getDouble("price")));
            }
            bookview.setItems(list);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }

    public void amatedosfeltable() throws SQLException {
        connection = Dbconnect.getConnect();
        Books books = bookview.getSelectionModel().getSelectedItem();
        query = "SELECT * FROM book ";
        preparedStatement =connection.prepareStatement(query);
        isbntext.setText(books.getISBN());
        preparedStatement.close();
    }
    public void deletebgd() throws SQLException {

        try {
            connection = Dbconnect.getConnect();
            Books books = (Books)bookview.getSelectionModel().getSelectedItem();
            query = "DELETE FROM book WHERE ISBN = ?";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1 , books.getISBN());
            pre.executeUpdate();
            preparedStatement.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Book Deleted Successfully! Refresh to see your current books");
            alert.show();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please choose a book to delete!");
            alert.show();
        }

    }
    @FXML
    void backbook(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
}
