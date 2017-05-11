package ru.esstu.db.service.impl;

import ru.esstu.db.dao.impl.CityDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.CityService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by RRM on 11.05.17.
 */
public class CityServiceImpl<City> extends AbstractServiceImpl<City> implements CityService<City> {

    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public CityServiceImpl() {
        dao = new CityDaoImpl<>(em);
    }
}
