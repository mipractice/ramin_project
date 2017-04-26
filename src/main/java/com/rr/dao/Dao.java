package com.rr.dao;

import java.util.List;

public interface Dao<T> {

    T get(long id);

    T add(T domain);

    void update(T domain);

    void delete(long id);

    List<T> getAll();

}