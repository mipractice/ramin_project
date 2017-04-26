package com.rr.dao.impl;

import com.rr.dao.Dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class CountryImpl<T> implements Dao<T> {
    @PersistenceContext
    protected EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    protected Class<T> Country;

    @Override
    public T getById(int id) {
        return entityManager.find(Country, id);
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
        //this.entityManager.clear();
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
        TypedQuery<T> studentTypedQuery = entityManager.createNamedQuery("Country.getAll", Country);
        return studentTypedQuery.getResultList();
    }
}
