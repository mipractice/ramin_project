package com.resud.controllers;

import com.resud.db.DBHelper;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by RRM on 07.04.17.
 */
public class ControllerOld {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView<User> tableDB;
    @FXML
    private TableColumn<User, Integer> tcID;
    @FXML
    private TableColumn<User, String> tcNAME;
    @FXML
    private TableColumn<User, String> tcAGE;
    @FXML
    private TableColumn<User, String> tcEMAIL;
    @FXML
    private Label lConnectStatus;
    private ObservableList<User> userObservableList;
    private DBHelper dbHelper = new DBHelper();


    public void btnSelect(ActionEvent actionEvent){
        try {
            userObservableList = FXCollections.observableArrayList();
            if (!dbHelper.getConnection().isClosed()) lConnectStatus.setText("Соединение с БД установлено!");
            else System.out.println("Ошибка подключения!");
            Statement statement = dbHelper.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

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

        tableDB.setItems(null);
        tableDB.setItems(userObservableList);
    }

    public void showDialog(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("dialogBox.fxml"));
            stage.setTitle("Добавление новой записи");
            stage.setMinWidth(300);
            stage.setMinHeight(150);
            stage.setResizable(false);
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void updateBD(ActionEvent actionEvent) {

        try {
            Statement statement = dbHelper.getConnection().createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteBD(ActionEvent actionEvent) {

        try {
            Statement statement = dbHelper.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("DELETE FROM users WHERE id = ");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
