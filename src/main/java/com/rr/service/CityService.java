package com.rr.service;

import com.rr.model.City;

import java.util.List;

public interface CityService {
    City getById(long id);

    City add(City city);

    void update(City city);

    void delete(City city);

    List<City> getAll();
}
