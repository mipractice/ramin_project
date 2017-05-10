package ru.esstu.db.dao;

import java.util.List;

/**
 * Created by RRM on 08.05.17.
 */
public interface Dao<T> {
    List<T> getAll();

    T getId(int id);

    T add(T domain);

    void update(T domain);

    void delete(int id);

}
