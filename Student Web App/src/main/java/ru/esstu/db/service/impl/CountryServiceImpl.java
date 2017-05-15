package ru.esstu.db.service.impl;

import javax.ejb.Singleton;
import ru.esstu.db.dao.Dao;
import ru.esstu.db.dao.impl.CountryDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.CountryService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by RRM on 08.05.17.
 */
@Singleton
public class CountryServiceImpl<Country> extends AbstractServiceImpl<Country> implements CountryService<Country> {
    protected Dao<Country> getDao()
    {
        if (dao == null) {
            dao = new CountryDaoImpl<>(em);
        }
        return dao;
    }

    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public CountryServiceImpl() {

    }
}
