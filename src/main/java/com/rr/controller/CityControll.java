package com.rr.controller;

import com.rr.alert.AlertBox;
import com.rr.dao.impl.dao.RegionDaoImpl;
import com.rr.dao.impl.service.CityServiceImpl;
import com.rr.dao.impl.service.RegionServiceImpl;
import com.rr.model.City;
import com.rr.model.Region;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CityControll {

    @FXML
    private TextField idTxt, cityTxt;
    @FXML
    private ComboBox<Region> regionCB;
    @FXML
    private TableView<City> tbCity;
    @FXML
    private TableColumn<City, Integer> tcId;
    @FXML
    private TableColumn<City, String> tcCity;
    @FXML
    private TableColumn<City, Integer> tcRegion;

    private AlertBox alert = new AlertBox();
    private RegionServiceImpl regionImpl = new RegionServiceImpl();
    private CityServiceImpl cityImpl = new CityServiceImpl();
    private List<City> allCity;
    private List<Region> allRegion = regionImpl.getAll();
    private ObservableList<City> cities;

    @FXML
    private void initialize() {
        for (Region region : allRegion) {
            regionCB.getItems().add(new Region(region.getId(), region.getName()));
        }
        viewCity();
    }

    public void viewCity() {
        allCity = cityImpl.getAll();
        cities = FXCollections.observableArrayList();

        tbCity.setItems(null);
        for (City city : allCity) {
            cities.add(new City(
                    city.getId(),
                    city.getName(),
                    city.getRegion()
            ));
        }
        tbCity.setItems(null);
        tbCity.setItems(cities);
        tcId.setCellValueFactory(new PropertyValueFactory<City, Integer>("id"));
        tcCity.setCellValueFactory(new PropertyValueFactory<City, String>("name"));
        tcRegion.setCellValueFactory(new PropertyValueFactory<City, Integer>("region"));
    }

    public void addCity(ActionEvent actionEvent) {
        if ((cityTxt.getText().length() > 0) && (regionCB.getSelectionModel().isEmpty())) {
            City city = new City();
            city.setName(cityTxt.getText());
            city.setRegion(new Region(regionCB.getSelectionModel().getSelectedItem().getId()));

            cityImpl.add(city);

            alert.setAlertInfo("Поздравляю!", "Новый город успешно добавлен в БД!", cityTxt.getText());
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является не обязательным.", "Не все поля заполнены!");
        }
        viewCity();
    }

    public void deleteCity(ActionEvent actionEvent) {
        System.out.println("Удалить горд");
    }

    public void updateCity(ActionEvent actionEvent) {
        System.out.println("Обновить горд");
    }
}
