package ru.esstu.db.dao.impl;

import ru.esstu.db.dao.AbstractDaoImpl;

import javax.persistence.EntityManager;

/**
 * Created by RRM on 08.05.17.
 */
public class CityDaoImpl<City> extends AbstractDaoImpl<City> {
    public CityDaoImpl(EntityManager em) {
        super(em);
    }
}
