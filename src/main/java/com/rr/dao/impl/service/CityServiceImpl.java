package com.rr.dao.impl.service;

import com.rr.dao.abst.AbstractService;
import com.rr.dao.impl.dao.CityDaoImpl;
import com.rr.dao.impl.dao.StudentDaoImpl;

public class CityServiceImpl<City> extends AbstractService {
    public CityServiceImpl() {
        dao = new CityDaoImpl();
    }
}
