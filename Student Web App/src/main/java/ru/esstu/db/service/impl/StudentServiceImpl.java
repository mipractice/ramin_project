package ru.esstu.db.service.impl;

import ru.esstu.db.dao.Dao;
import ru.esstu.db.dao.impl.StudentDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.StudentService;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by RRM on 08.05.17.
 */
@Singleton
public class StudentServiceImpl<Student> extends AbstractServiceImpl<Student> implements StudentService<Student> {

    protected Dao<Student> getDao() {
        if (dao == null)
            dao = new StudentDaoImpl<>(em);
        return dao;
    }

    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    public StudentServiceImpl() {
    }
}
