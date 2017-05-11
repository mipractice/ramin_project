package ru.esstu.db.dao.impl;

import ru.esstu.db.dao.AbstractDaoImpl;

import javax.persistence.EntityManager;

/**
 * Created by RRM on 08.05.17.
 */
public class StudentDaoImpl<Student> extends AbstractDaoImpl<Student> {
    public StudentDaoImpl(EntityManager em) {
        super(em);
    }
}
