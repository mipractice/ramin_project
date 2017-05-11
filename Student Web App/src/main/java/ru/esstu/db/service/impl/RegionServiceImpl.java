package ru.esstu.db.service.impl;

import ru.esstu.db.dao.impl.RegionDaoImpl;
import ru.esstu.db.service.AbstractServiceImpl;
import ru.esstu.db.service.i.RegionService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by RRM on 11.05.17.
 */
public class RegionServiceImpl<Region> extends AbstractServiceImpl<Region> implements RegionService<Region> {

    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public RegionServiceImpl() {
        dao = new RegionDaoImpl<>(em);
    }
}
