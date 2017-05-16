package ru.esstu.db.service;

import ru.esstu.db.dao.Dao;

import java.util.List;

/**
 * Created by RRM on 08.05.17.
 */
public abstract class AbstractServiceImpl<T> implements Service<T> {

    protected abstract Dao<T> getDao();

    public Dao<T> dao;

    @Override
    public List<T> getAll() {
        return getDao().getAll();
    }

    @Override
    public T getId(int id) {
        return getDao().getId(id);
    }

    @Override
    public T add(T domain) {
        return getDao().add(domain);
    }

    @Override
    public void update(T domain) {
        getDao().update(domain);
    }

    @Override
    public void delete(int id) {
        getDao().delete(id);
    }
}
