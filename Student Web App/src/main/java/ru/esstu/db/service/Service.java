package ru.esstu.db.service;

import java.util.List;

/**
 * Created by RRM on 08.05.17.
 */
public interface Service<T> {

    List<T> getAll();

    T getId(int id);

    T add(T domain);

    void update(T domain);

    void delete(int id);

}