package com.rr.controller;

import com.rr.dao.impl.StudentImpl;
import com.rr.model.City;
import com.rr.dao.impl.CityImpl;
import com.rr.model.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;
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
    @FXML
    private TableView<Student> tbStudent;
    @FXML
    private TableColumn<Student, Long> tcId;
    @FXML
    private TableColumn<Student, String> tcSurname, tcName, tcGender, tcAddress, tcPhone;
    @FXML
    private TableColumn<Student, Date> tcBirthday;
    @FXML
    private TableColumn<Student, Integer> tcCity;

    private CityImpl ciyImpl = new CityImpl();
    private StudentImpl studentImpl = new StudentImpl();
    private List<City> listCity = ciyImpl.getAll();
    private List<Student> listStudent = studentImpl.getAll();
    private ObservableList<Student> studentObservableList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        fxGender.getItems().addAll("Мужской", "Женский");
        for (City city : listCity) {
            fxCity.getItems().add(new City(city.getId(), city.getName()));
        }
        loadStudent();
    }


    public void loadStudent() {
        for (Student student : listStudent) {
            studentObservableList.add(new Student(
                    student.getGender(),
                    student.getBirthday(),
                    student.getPhone(),
                    student.getAddress(),
                    student.getId(),
                    student.getFirstname(),
                    student.getSurname(),
                    student.getCity()
            ));
            System.out.println(student);
        }
        tbStudent.setItems(studentObservableList);

        tcId.setCellValueFactory(new PropertyValueFactory<Student, Long>("id"));
        tcSurname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        tcName.setCellValueFactory(new PropertyValueFactory<Student, String>("firstname"));
        tcGender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
        tcBirthday.setCellValueFactory(new PropertyValueFactory<Student, Date>("birthday"));
        tcCity.setCellValueFactory(new PropertyValueFactory<Student, Integer>("city"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
    }


    public void add(ActionEvent actionEvent) {

    }

    public void update(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void print(ActionEvent actionEvent) {
//        System.out.println("# - " + fxCity.getSelectionModel().getSelectedItem().getId());q
    }

}
