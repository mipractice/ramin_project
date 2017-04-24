package com.rr.service.impl;

import com.rr.model.City;
import com.rr.service.CityService;

import javax.persistence.*;
import java.util.List;

public class CityImpl implements CityService {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();



    @Override
    public City getById(long id) {
        return null;
    }

    @Override
    public City add(City city) {
        return null;
    }

    @Override
    public void update(City city) {

    }

    @Override
    public void delete(City city) {

    }

    @Override
    public List<City> getAll() {
        TypedQuery<City> studentTypedQuery = entityManager.createNamedQuery("City.getAll", City.class);
        return studentTypedQuery.getResultList();
    }
}
