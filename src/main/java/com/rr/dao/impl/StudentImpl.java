package com.rr.dao.impl;

import com.rr.dao.StudentDao;
import com.rr.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentImpl implements StudentDao {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();

    @Override
    public Student getById(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student add(Student student) {
        entityManager.getTransaction().begin();
        Student addStudent = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return addStudent;
    }

    @Override
    public void update(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> studentTypedQuery = entityManager.createNamedQuery("Student.getAll", Student.class);
        return studentTypedQuery.getResultList();
    }
}
