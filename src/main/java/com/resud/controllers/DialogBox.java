package com.resud.controllers;

import com.resud.DB.DBHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

/**
 * Created by RRM on 08.04.17.
 */
public class DialogBox {

    @FXML
    private Button btnInsert;
    @FXML
    private Button btnClear;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfEmail;


    public void insertDB(ActionEvent actionEvent){

        DBHelper dbHelper = new DBHelper();

        try {
            Statement statement = dbHelper.getConnection().createStatement();
            statement.execute("INSERT INTO users (name, age, email) VALUES('"
                                + tfName.getText() + "', "
                                + tfAge.getText() + ", '"
                                + tfEmail.getText() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clear(ActionEvent actionEvent) {
    }
}
