package com.rr.dao.impl;

import com.rr.dao.Dao;
import com.rr.model.City;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class CityImpl<T, PK extends Serializable> implements Dao<City> {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();


    @Override
    public City get(long id) {
        return null;
    }

    @Override
    public City add(City domain) {
        return null;
    }

    @Override
    public void update(City domain) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<City> getAll() {
        TypedQuery<City> studentTypedQuery = entityManager.createNamedQuery("City.getAll", City.class);
        return studentTypedQuery.getResultList();
    }
}
