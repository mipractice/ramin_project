package com.rr.dao.impl.service;

import com.rr.dao.abst.AbstractService;
import com.rr.dao.impl.dao.CityDaoImpl;
import com.rr.dao.impl.dao.CountryDaoImpl;

public class CountryServiceImpl<Country> extends AbstractService {
    public CountryServiceImpl() {
        dao = new CountryDaoImpl();
    }
}
