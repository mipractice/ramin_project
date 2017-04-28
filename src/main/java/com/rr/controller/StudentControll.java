package com.rr.controller;

import com.rr.alert.AlertBox;
import com.rr.dao.impl.StudentImpl;
import com.rr.model.City;
import com.rr.dao.impl.CityImpl;
import com.rr.model.Student;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StudentControll {

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
        LocalDate defualtDate = LocalDate.parse("1992-01-01");
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
        }
        tbStudent.setItems(null);
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
        if ((fxFirstname.getText().length() > 0) && (fxSurname.getText().length() > 0) && (!fxGender.getSelectionModel().isEmpty()) &&
                (fxAddress.getText().length() > 0) && (fxPhone.getText().length() > 0) && (!fxCity.getSelectionModel().isEmpty())) {
            Student student = new Student();
            student.setFirstname(fxFirstname.getText());
            student.setSurname(fxSurname.getText());
            student.setGender(fxGender.getSelectionModel().getSelectedItem());
            student.setBirthday(new Date(fxBirthday.getValue().getYear() - 1900, fxBirthday.getValue().getMonthValue() - 1, fxBirthday.getValue().getDayOfMonth()));
            student.setAddress(fxAddress.getText());
            student.setPhone(fxPhone.getText());
            student.setCity(new City(fxCity.getSelectionModel().getSelectedItem().getId()));
            studentImpl.add(student);
            alert.setAlertInfo("Поздравляю!", "Новый студент успешно добавлен в БД!",
                    fxSurname.getText() + " " + fxFirstname.getText() +
                            "\nПол: " + fxGender.getSelectionModel().getSelectedItem() +
                            "\nДата рождения: " + fxBirthday.getValue() +
                            "\nАдрес: " + fxAddress.getText() + " (" + fxCity.getSelectionModel().getSelectedItem() + ")" +
                            "\nТелефон: " + fxPhone.getText());
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является не обязательным.", "Не все поля заполнены!");
        }

    }

    public void update(ActionEvent actionEvent) {
        if ((fxFirstname.getText().length() > 0) && (fxSurname.getText().length() > 0) && (!fxGender.getSelectionModel().isEmpty()) &&
                (fxAddress.getText().length() > 0) && (fxPhone.getText().length() > 0) && (!fxCity.getSelectionModel().isEmpty())) {
            Student student = (Student) studentImpl.getById(Integer.parseInt(fxId.getText()));
            student.setFirstname(fxFirstname.getText());
            student.setSurname(fxSurname.getText());
            student.setGender(fxGender.getSelectionModel().getSelectedItem());
            student.setBirthday(new Date(fxBirthday.getValue().getYear() - 1900,
                    fxBirthday.getValue().getMonthValue() - 1,
                    fxBirthday.getValue().getDayOfMonth()));
            student.setAddress(fxAddress.getText());
            student.setPhone(fxPhone.getText());
            student.setCity(new City(fxCity.getSelectionModel().getSelectedItem().getId()));

            studentImpl.update(student);
            alert.setAlertInfo("Поздравляю!", "Студент был изменен.", null);
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является обязательным.", "Удаление происходит по выбору порядкового номера '№'!");
        }
    }

    public void delete(ActionEvent actionEvent) {
        if (fxId.getText().length() > 0) {
            alert.setAlertInfo("Поздравляю!", "Студент под №: " + fxId.getText() + ". был удален из БД!", null);
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является обязательным.", "Удаление происходит по выбору порядкового номера '№'!");
        }
    }

    public void print(ActionEvent actionEvent) {
        loadStudent();
    }

    public void pick(MouseEvent mouseEvent) {
        tbStudent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fxId.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getId()));
                fxFirstname.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getFirstname()));
                fxSurname.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getSurname()));
                fxGender.setValue(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getGender()));
                LocalDate birthday = LocalDate.parse(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getBirthday()));
                fxBirthday.setValue(birthday);
                fxCity.setValue(new City(tbStudent.getSelectionModel().getSelectedItem().getCity().getId(),
                        String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getCity())));
                fxAddress.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getAddress()));
                fxPhone.setText(String.valueOf(tbStudent.getSelectionModel().getSelectedItem().getPhone()));
            }
        });
    }

    public void country(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/country.fxml"));
            stage.setTitle("Страна");
            stage.setScene(new Scene(parent, 430, 400));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void region(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/region.fxml"));
            stage.setTitle("Регион");
            stage.setScene(new Scene(parent, 600, 400));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void city(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();

            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/city.fxml"));
            stage.setTitle("Город");
            stage.setScene(new Scene(parent, 600, 400));
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
