package com.rr.dao;

import org.hibernate.criterion.DetachedCriteria;
import java.io.Serializable;
import java.util.List;

public interface DAO<T> {

    public List<T> getAll();

    public void add(T domain);

    public void update(T domain);

    public void delete(T domain);

    public T get(Serializable id);

    public List<T> getListByCriteria(DetachedCriteria detachedCriteria);

    public List<T> getListByCriteria(DetachedCriteria detachedCriteria, int offset, int size);
}