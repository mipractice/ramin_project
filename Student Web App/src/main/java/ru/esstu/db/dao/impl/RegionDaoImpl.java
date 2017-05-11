package ru.esstu.db.dao.impl;

import ru.esstu.db.dao.AbstractDaoImpl;

import javax.persistence.EntityManager;

/**
 * Created by RRM on 08.05.17.
 */
public class RegionDaoImpl<Region> extends AbstractDaoImpl<Region> {
    public RegionDaoImpl(EntityManager em) {
        super(em);
    }
}
