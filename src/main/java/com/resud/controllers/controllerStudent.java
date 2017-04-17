package com.resud.controllers;

import com.resud.db.DBHelper;
import com.resud.alert.alertBox;
import com.resud.entity.Student;
import com.resud.function.funcStudent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.List;

/**
 * Created by RRM on 08.04.17.
 */
public class controllerStudent {

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
    private alertBox alertBox = new alertBox();

//    public void selectDB(ActionEvent actionEvent) {
//        try {
//            userObservableList = FXCollections.observableArrayList();
//            ResultSet resultSet = dbHelper.getConnection().createStatement().executeQuery("SELECT * FROM users;");
//            while (resultSet.next()) {
//                userObservableList.add(new User(resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getString("age"),
//                        resultSet.getString("email")));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        tcID.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
//        tcNAME.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
//        tcAGE.setCellValueFactory(new PropertyValueFactory<User, String>("age"));
//        tcEMAIL.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
//
//        tbUsers.setItems(null);
//        tbUsers.setItems(userObservableList);
//    }

    private funcStudent studentMethod = new funcStudent();

    public void insertDB(ActionEvent actionEvent) {
        if ((tfName.getText().trim().length() > 0)
                && (tfAge.getText().trim().length() > 0)
                && (tfEmail.getText().trim().length() > 0)) {
            Student student = new Student();
            student.setNameStudent(tfName.getText());
            student.setAgeStudent(Integer.parseInt(tfAge.getText()));
            student.setEmailStudent(tfEmail.getText());
            studentMethod.addStudent(student);
            alertBox.Info("Поздравляю!", tfName.getText() + " успешно добавлен в БД!", null);
        } else {
            alertBox.Warning("Предупреждение!", "Поле ID является не обязательным.", "Не все поля заполнены!");
        }
    }

    public void deleteDB(ActionEvent actionEvent) {

        if (tfID.getText().trim().length() > 0) {
            studentMethod.deleteStudent(Integer.parseInt(tfID.getText()));
            alertBox.Info("Поздравляю!", "Пользователь под # " + tfID.getText() + ". был удален из БД!", null);
        } else {
            alertBox.Warning("Предупреждение!", "Поле ID является обязательным.", "Удаление происходит по выбору порядкового номера (ID)!");
        }
    }

    public void updateDB(ActionEvent actionEvent) {
        if ((tfName.getText().trim().length() > 0)
                && (tfAge.getText().trim().length() > 0)
                && (tfEmail.getText().trim().length() > 0)) {

            Student student = studentMethod.get(Integer.parseInt(tfID.getText()));
            student.setNameStudent(tfName.getText());
            student.setAgeStudent(Integer.parseInt(tfAge.getText()));
            student.setEmailStudent(tfEmail.getText());

            studentMethod.updateStudent(student);

            alertBox.Info("Поздравляю!", "Пользователь был изменен.", null);
        } else {
            alertBox.Warning("Предупреждение!", "Поле ID является не обязательным.", "Не все поля заполнены!");
        }
    }

    public void selectDB(ActionEvent actionEvent) {
        List<Student> students = studentMethod.getAllStudent();

        for (Student stu : students) {
            System.out.println(stu);
        }
    }

}
