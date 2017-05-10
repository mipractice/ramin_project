package ru.esstu.db.dao.impl;

import ru.esstu.db.dao.AbstractDao;

import javax.persistence.EntityManager;

/**
 * Created by RRM on 08.05.17.
 */
public class RegionImplDao<Region> extends AbstractDao<Region> {
    public RegionImplDao(EntityManager em) {
        super(em);
    }
}
