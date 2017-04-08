package com.resud.controllers;

import com.resud.DB.DBHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

/**
 * Created by RRM on 08.04.17.
 */
public class Controller {

    @FXML
    private TextField tfID;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfEmail;
    @FXML
    private TableView<User> tbUsers;
    @FXML
    private TableColumn<User, Integer> tcID;
    @FXML
    private TableColumn<User, String> tcNAME;
    @FXML
    private TableColumn<User, String> tcAGE;
    @FXML
    private TableColumn<User, String> tcEMAIL;

    private ObservableList<User> userObservableList;
    private DBHelper dbHelper = new DBHelper();

    public void selectDB(ActionEvent actionEvent) {
        try {
            userObservableList = FXCollections.observableArrayList();
            ResultSet resultSet = dbHelper.getConnection().createStatement().executeQuery("SELECT * FROM users;");
            while (resultSet.next()){
                userObservableList.add(new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("age"),
                        resultSet.getString("email")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        tcNAME.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        tcAGE.setCellValueFactory(new PropertyValueFactory<User, String>("age"));
        tcEMAIL.setCellValueFactory(new PropertyValueFactory<User, String>("email"));

        tbUsers.setItems(null);
        tbUsers.setItems(userObservableList);
    }

    public void insertDB(ActionEvent actionEvent) {
        try {
            dbHelper.getConnection().createStatement().execute("INSERT INTO users (name, age, email) VALUES('"
                    + tfName.getText() + "', "
                    + Integer.parseInt(tfAge.getText()) + ", '"
                    + tfEmail.getText() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDB(ActionEvent actionEvent) {
        try {
            dbHelper.getConnection().createStatement().executeUpdate("UPDATE users SET " +
                    "name = ' " + tfName.getText() + " ', " +
                    "age = " + Integer.parseInt(tfAge.getText()) + ", " +
                    "email = ' " + tfEmail.getText() + " ' " +
                    "WHERE id = " + Integer.parseInt(tfID.getText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDB(ActionEvent actionEvent) {
        try {
            dbHelper.getConnection().createStatement().execute("DELETE FROM users WHERE id = " + Integer.parseInt(tfID.getText()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
