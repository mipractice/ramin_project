package ru.esstu.db.dao.impl;

import ru.esstu.db.dao.AbstractDaoImpl;

import javax.persistence.EntityManager;
import ru.esstu.db.dao.Dao;

/**
 * Created by RRM on 08.05.17.
 */
public class CountryDaoImpl<Country> extends AbstractDaoImpl<Country> {

    public CountryDaoImpl(EntityManager em) {
        super(em);
    }
}
