package com.rr.dao.impl;

import com.rr.dao.Dao;
import com.rr.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class StudentImpl<T, PK extends Serializable> implements Dao<Student> {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();

    @Override
    public Student get(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student add(Student domain) {
        entityManager.getTransaction().begin();
        Student addStudent = entityManager.merge(domain);
        entityManager.getTransaction().commit();
        return addStudent;
    }

    @Override
    public void update(Student domain) {
        entityManager.getTransaction().begin();
        entityManager.merge(domain);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> studentTypedQuery = entityManager.createNamedQuery("Student.getAll", Student.class);
        return studentTypedQuery.getResultList();
    }
}
