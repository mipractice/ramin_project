package com.rr.dao.abst;

import com.rr.dao.Dao;
import com.rr.dao.Service;

import java.util.List;

public abstract class AbstractService<T> implements Service<T> {

    public Dao<T> dao;

    public void setDao(Dao<T> dao) {
        this.dao = dao;
    }

    @Override
    public T getById(int id) {
        return dao.getById(id);
    }

    @Override
    public T add(T domain) {
        return dao.add(domain);
    }

    @Override
    public void update(T domain) {
        dao.update(domain);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }
}
