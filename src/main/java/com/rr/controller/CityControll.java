package com.rr.controller;

import com.rr.model.City;
import com.rr.model.Region;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CityControll {

    @FXML
    private TextField idTxt, cityTxt;
    @FXML
    private ComboBox<Region> regionCB;
    @FXML
    private TableView<City> tbCity;
    @FXML
    private TableColumn<City, Long> tcId;
    @FXML
    private TableColumn<City, String> tcCity;
    @FXML
    private TableColumn<City, Integer> tcRegion;

    private Region region = new Region();

    @FXML
    private void initialize() {

    }

    public void addCity(ActionEvent actionEvent) {



        System.out.println("Добавить горд");
    }

    public void deleteCity(ActionEvent actionEvent) {
        System.out.println("Удалить горд");
    }

    public void updateCity(ActionEvent actionEvent) {
        System.out.println("Обновить горд");
    }
}
