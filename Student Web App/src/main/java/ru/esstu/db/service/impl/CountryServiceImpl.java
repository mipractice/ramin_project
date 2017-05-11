package ru.esstu.db.service.impl;

import ru.esstu.db.dao.impl.CountryDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.CountryService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by RRM on 08.05.17.
 */
@Stateless
public class CountryServiceImpl<Country> extends AbstractServiceImpl<Country> implements CountryService<Country> {

    @PersistenceContext(unitName = "Student")
    private EntityManager em;

    public CountryServiceImpl() {
        dao = new CountryDaoImpl<Country>(em);
    }
}
