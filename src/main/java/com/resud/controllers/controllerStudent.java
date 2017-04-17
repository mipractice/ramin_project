package com.resud.controllers;

import com.resud.alert.alertBox;
import com.resud.entity.Student;
import com.resud.function.funcStudent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableView<fxStudent> tbUsers;
    @FXML
    private TableColumn<fxStudent, Long> tcID;
    @FXML
    private TableColumn<fxStudent, String> tcNAME;
    @FXML
    private TableColumn<fxStudent, Integer> tcAGE;
    @FXML
    private TableColumn<fxStudent, String> tcEMAIL;

    private ObservableList<fxStudent> userObservableList;
    private alertBox alertBox = new alertBox();

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
        List<Student> lsStudent = studentMethod.getAllStudent();
        userObservableList = FXCollections.observableArrayList();
        for (Student student : lsStudent){
            userObservableList.add(new fxStudent(student.getIdStudent(), student.getAgeStudent(), student.getNameStudent(), student.getEmailStudent()));
        }

        tbUsers.setItems(userObservableList);
        tbUsers.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tcID.setCellValueFactory(new PropertyValueFactory<fxStudent, Long>("idStudent"));
        tcNAME.setCellValueFactory(new PropertyValueFactory<fxStudent, String>("nameStudent"));
        tcAGE.setCellValueFactory(new PropertyValueFactory<fxStudent, Integer>("ageStudent"));
        tcEMAIL.setCellValueFactory(new PropertyValueFactory<fxStudent, String>("emailStudent"));

    }


    public void pickTableItem(MouseEvent mouseEvent) {
        tbUsers.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                tfID.setText(String.valueOf(tbUsers.getSelectionModel().getSelectedItem().getIdStudent()));
                tfName.setText(tbUsers.getSelectionModel().getSelectedItem().getNameStudent());
                tfAge.setText(String.valueOf(tbUsers.getSelectionModel().getSelectedItem().getAgeStudent()));
                tfEmail.setText(tbUsers.getSelectionModel().getSelectedItem().getEmailStudent());
            }
        });
    }
}
