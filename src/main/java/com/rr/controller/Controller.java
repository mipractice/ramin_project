package com.rr.controller;

import com.rr.entity.City;
import com.rr.entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sun.util.resources.LocaleData;

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

public class Controller {

    @FXML
    private TextField fxId, fxFirstname, fxSurname, fxAddress, fxPhone;
    @FXML
    private ComboBox<String> fxGender;
    @FXML
    private ComboBox<City> fxCity;
    @FXML
    private DatePicker fxBirthday;

    @FXML
    private void initialize() {
//        fxCity.getItems().add(new City(1, "Москва"));
//        fxCity.getItems().add(new City(2, "Улан-Удэ"));
//        fxCity.getItems().add(new City(3, "Иркутск"));

        fxGender.getItems().addAll("Мужской", "Женский");
    }


    public void loadTableStudent() {
        System.out.println("Будет загружаться таблица с этого метода!");
    }


    public void add(ActionEvent actionEvent) {

    }

    public void update(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void print(ActionEvent actionEvent) {
//        Student student = new Student();
//        student.setFirstname("Рамин");
//        student.setSurname("Расули");
//        student.setGender("Мужской");
//        student.setBirthday(new Date(2012, 01, 24));
//        student.setAddress("Рылеева 3 16");
//        student.setPhone("+7(950) 386-34-44");
//        student.setCity(new City(1, "Улан-Удэ"));
//
//        System.out.println(student);

//        Student student1 = new Student();
//        student1.setFirstname(fxFirstname.getText());
//        student1.setSurname(fxSurname.getText());
//        student1.setGender(fxGender.getSelectionModel().getSelectedItem());
//        student1.setBirthday(new Date(1994, 01, 24));
//        student1.setAddress(fxAddress.getText());
//        student1.setPhone(fxPhone.getText());
//        student1.setCity(new City(fxCity.getSelectionModel().getSelectedItem().getId(), fxCity.getSelectionModel().getSelectedItem().getName()));
//        System.out.println("# - " + fxCity.getSelectionModel().getSelectedItem().getId());
//
//
//        System.out.println(student1);
    }
}
