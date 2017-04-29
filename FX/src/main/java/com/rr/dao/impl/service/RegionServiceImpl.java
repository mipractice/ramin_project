package com.rr.dao.impl.service;

import com.rr.dao.abst.AbstractService;
import com.rr.dao.impl.dao.RegionDaoImpl;

public class RegionServiceImpl<Region> extends AbstractService{
    public RegionServiceImpl(){dao = new RegionDaoImpl();}
}
