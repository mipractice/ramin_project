package ru.esstu.db.dao;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RRM on 08.05.17.
 */
public abstract class AbstractDao<T> implements Dao<T> {

//    @PersistenceContext(unitName = "Student", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em;
//    = Persistence.createEntityManagerFactory("Student").createEntityManager();
    private Class<T> entityClass;
    private Class<? extends AbstractDao> getClass = getClass();
    private String parmClass = getClass.getSimpleName();


    public AbstractDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<T> getAll() {
        TypedQuery<T> select = em.createNamedQuery(parmClass + ".getAll", entityClass);
        return select.getResultList();
    }

    @Override
    public T getId(int id) {
        TypedQuery<T> find = em.createNamedQuery(parmClass + ".find", entityClass);
        find.setParameter("id", id);
        return find.getSingleResult();
    }

    @Override
    public T add(T domain) {
        return null;
    }

    @Override
    public void update(T domain) {

    }

    @Override
    public void delete(int id) {

    }
}
