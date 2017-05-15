package ru.esstu.db.service.impl;

import javax.ejb.Singleton;
import ru.esstu.db.dao.Dao;
import ru.esstu.db.dao.impl.CityDaoImpl;
import ru.esstu.db.dao.impl.CountryDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.CityService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by RRM on 11.05.17.
 */
@Singleton
public class CityServiceImpl<City> extends AbstractServiceImpl<City> implements CityService<City> {
    protected Dao<City> getDao()
    {
        if (dao == null) {
            dao = new CityDaoImpl<>(em);
        }
        return dao;
    }

    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public CityServiceImpl() {

    }
}
