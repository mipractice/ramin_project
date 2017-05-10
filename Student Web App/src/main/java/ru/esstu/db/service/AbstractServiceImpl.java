package ru.esstu.db.service;

import ru.esstu.db.dao.Dao;

import java.util.List;

/**
 * Created by RRM on 08.05.17.
 */
public class AbstractServiceImpl<T> implements Service<T> {

    public Dao<T> dao;

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T getId(int id) {
        return dao.getId(id);
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
}
