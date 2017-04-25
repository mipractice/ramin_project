package com.rr.controller;

import com.rr.alert.AlertBox;
import com.rr.dao.impl.StudentImpl;
import com.rr.model.City;
import com.rr.dao.impl.CityImpl;
import com.rr.model.Student;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.LocalDateStringConverter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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

    private AlertBox alert = new AlertBox();
    private CityImpl ciyImpl = new CityImpl();
    private StudentImpl studentImpl = new StudentImpl();

    private List<City> listCity = ciyImpl.getAll();
    private List<Student> listStudent;
    private ObservableList<Student> studentObservableList;

    @FXML
    private void initialize() {
        LocalDate defualtDate = LocalDate.parse("1990-01-01");
        fxBirthday.setValue(defualtDate);
        fxGender.getItems().addAll("Мужской", "Женский");
        for (City city : listCity) {
            fxCity.getItems().add(new City(city.getId(), city.getName()));
        }
        loadStudent();
    }

    public void loadStudent() {
        listStudent = studentImpl.getAll();
        studentObservableList = FXCollections.observableArrayList();


        tbStudent.setItems(null);
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
        Student student = new Student();

        student.setFirstname(fxFirstname.getText());
        student.setSurname(fxSurname.getText());
        student.setGender(fxGender.getSelectionModel().getSelectedItem());
        student.setBirthday(new Date(fxBirthday.getValue().getYear() - 1900,
                fxBirthday.getValue().getMonthValue() - 1,
                fxBirthday.getValue().getDayOfMonth()));
        student.setAddress(fxAddress.getText());
        student.setPhone(fxPhone.getText());
        student.setCity(new City(fxCity.getSelectionModel().getSelectedItem().getId()));

        studentImpl.add(student);

        System.out.println(student);

    }

    public void update(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void print(ActionEvent actionEvent) {
        loadStudent();

//        System.out.println("# - " + fxCity.getSelectionModel().getSelectedItem().getId());q
    }

    public void pick(MouseEvent mouseEvent) {
        tbStudent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fxId.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getId()));
                fxFirstname.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getFirstname()));
                fxSurname.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getSurname()));
                //fxGender.
                //fxBirthday.setValue(tbStudent.getSelectionModel().getSelectedItem().getBirthday());
                //fxCity.
                fxAddress.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getAddress()));
                fxPhone.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getPhone()));
            }
        });
    }
}
