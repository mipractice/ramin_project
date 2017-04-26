package com.rr.dao.impl;

import com.rr.dao.Dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class CityImpl<T> implements Dao<T> {
    @PersistenceContext
    protected EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    protected Class<T> City;

    @Override
    public T getById(int id) {
        return entityManager.find(City, id);
    }

    @Override
    public T add(T domain) {
        this.entityManager.getTransaction().begin();
        this.entityManager.clear();
        this.entityManager.merge(domain);
        this.entityManager.getTransaction().commit();
        return domain;
    }

    @Override
    public void update(T domain) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(domain);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(getById(id));
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<T> getAll() {
        TypedQuery<T> cityTypedQuery = entityManager.createNamedQuery("City.getAll", City);
        return cityTypedQuery.getResultList();
    }

}
