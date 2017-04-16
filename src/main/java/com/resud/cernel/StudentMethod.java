package com.resud.cernel;

import com.resud.entity.Student;

import javax.persistence.*;
/**
 * Created by RRM on 16.04.17.
 */
public class StudentMethod {
//    private EntityManager entityManager;
//
//    public StudentMethod() {
//        init();
//    }
//
//    private void init() {
//        this.entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();
//    }
//

       private EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();

    public Student add(Student student){
        entityManager.getTransaction().begin();
        Student studentFromDB = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return studentFromDB;
    }

}
