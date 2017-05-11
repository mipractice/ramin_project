package ru.esstu.db.service.impl;

import ru.esstu.db.dao.impl.StudentDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.StudentService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by RRM on 08.05.17.
 */
public class StudentServiceImpl<Student> extends AbstractServiceImpl<Student> implements StudentService<Student> {


    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    public StudentServiceImpl() {
        dao = new StudentDaoImpl<>(em);
    }
}
