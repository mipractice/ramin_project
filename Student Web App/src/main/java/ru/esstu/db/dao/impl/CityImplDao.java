package ru.esstu.db.dao.impl;

import ru.esstu.db.dao.AbstractDao;

import javax.persistence.EntityManager;

/**
 * Created by RRM on 08.05.17.
 */
public class CityImplDao<City> extends AbstractDao<City> {
    public CityImplDao(EntityManager em) {
        super(em);
    }
}
