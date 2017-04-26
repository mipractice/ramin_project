package com.rr.dao.impl;

import com.rr.dao.Dao;
import com.rr.model.Student;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class StudentImpl<T> implements Dao<T> {
    @PersistenceContext
    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    private Class<T> Student;

    @Override
    public T getById(int id) {
        TypedQuery<T> findStudent= this.entityManager.createNamedQuery("Student.find", Student);
        findStudent.setParameter("id", id);
        return findStudent.getSingleResult();
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
        TypedQuery<T> studentTypedQuery = this.entityManager.createNamedQuery("Student.getAll", Student);
        return studentTypedQuery.getResultList();
    }
}