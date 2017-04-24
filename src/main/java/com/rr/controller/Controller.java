package com.rr.controller;

import com.rr.model.City;
import com.rr.service.impl.CityImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class Controller {

    @FXML
    private TextField fxId, fxFirstname, fxSurname, fxAddress, fxPhone;
    @FXML
    private ComboBox<String> fxGender;
    @FXML
    private ComboBox<City> fxCity;
    @FXML
    private DatePicker fxBirthday;

    private CityImpl ciyImpl = new CityImpl();
    private List<City> listCity = ciyImpl.getAll();

    @FXML
    private void initialize() {
        fxGender.getItems().addAll("Мужской", "Женский");
        for (City city: listCity) {
            fxCity.getItems().add(new City(city.getId(), city.getName()));
        }
        loadTableStudent();
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
        System.out.println("# - " + fxCity.getSelectionModel().getSelectedItem().getId());
//
//
//        System.out.println(student1);
    }
}
