package ru.esstu.db.service.impl;

import ru.esstu.db.dao.impl.StudentDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.StudentService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by RRM on 08.05.17.
 */
@Stateless
public class StudentServiceImpl<Student> extends AbstractServiceImpl<Student> implements StudentService<Student> {

    @PersistenceContext(unitName = "Student")
    EntityManager em;

    public StudentServiceImpl() {
        dao = new StudentDaoImpl<Student>(em);
    }
}
