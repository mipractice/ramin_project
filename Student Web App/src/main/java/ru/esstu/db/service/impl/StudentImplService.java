package ru.esstu.db.service.impl;

import ru.esstu.db.dao.impl.StudentImplDao;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.StudentService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by RRM on 08.05.17.
 */
@Stateless
public class StudentImplService<Student> extends AbstractServiceImpl<Student> implements StudentService<Student> {

    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    public StudentImplService() {
        dao = new StudentImplDao<>(em);
    }
}
