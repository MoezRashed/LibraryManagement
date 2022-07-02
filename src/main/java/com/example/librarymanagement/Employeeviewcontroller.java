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

public class Employeeviewcontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<Employee,String> Emailcol;
    @FXML
    private TableColumn<Employee, Integer> EmployeeIDcol;
    @FXML
    private TableView<Employee> Employeeview;
    @FXML
    private TableColumn<Employee,String> Namecol;
    @FXML
    private TableColumn<Employee, Double> Phonecol;
    @FXML
    private TextField empid;
    @FXML
    private AnchorPane RootPane6;
    @FXML
    private TableColumn<Employee, Integer> Salarycol;
    @FXML
    private Button backbutton;
    @FXML
    private Button deletebutton;
    String query = null;
    Connection connection =null;
    Statement preparedStatement = null;
    ResultSet resultSet= null;
    ObservableList<Employee> list = FXCollections.observableArrayList();

    @FXML
    void Deleteemployee(ActionEvent event) throws SQLException {
        connection = Dbconnect.getConnect();
        Namecol.setCellValueFactory(new PropertyValueFactory<Employee ,String >("name"));
        Emailcol.setCellValueFactory(new PropertyValueFactory<Employee ,String >("email"));
        Phonecol.setCellValueFactory(new PropertyValueFactory<Employee ,Double> ("phone"));
        Salarycol.setCellValueFactory(new PropertyValueFactory<Employee ,Integer >("salary"));
        EmployeeIDcol.setCellValueFactory(new PropertyValueFactory<Employee ,Integer >("employeeID"));



        list.clear();

        try {
            query = "SELECT * FROM employee ";
            connection = Dbconnect.getConnect();
            preparedStatement = connection.createStatement();
            resultSet = preparedStatement.executeQuery(query);
            while(resultSet.next())
            {
                list.add(new Employee(resultSet.getString("name"),
                                      resultSet.getString("email"),
                                      resultSet.getString("phone"),
                                      resultSet.getInt("salary"),
                                      resultSet.getInt("employeeID")));
            }
            Employeeview.setItems(list);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }


    @FXML
    void backEmployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Main Menu");
        stage.show();
    }
    public void amatedosfeltable() throws SQLException {
        connection = Dbconnect.getConnect();
        Employee employee = Employeeview.getSelectionModel().getSelectedItem();
        query = "SELECT * FROM employee ";
        preparedStatement =connection.prepareStatement(query);
        empid.setText(String.valueOf(employee.getEmployeeID()));
        preparedStatement.close();
    }
    public void deletebgd() throws SQLException
    {
        try {
            connection = Dbconnect.getConnect();
            Employee employee = (Employee)Employeeview.getSelectionModel().getSelectedItem();
            query = "DELETE FROM employee WHERE EmployeeID = ?";
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1 , String.valueOf(employee.getEmployeeID()));
            pre.executeUpdate();
            preparedStatement.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Employee Deleted Successfully! Refresh to see your current employees");
            alert.show();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please choose employee to delete!");
            alert.show();
        }
    }
}