package com.resud.function;

import com.resud.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class funcStudent {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();

    public Student addStudent(Student student) {
        entityManager.getTransaction().begin();
        Student studentFromDB = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return studentFromDB;
    }


    public void deleteStudent(long idStudent){
        entityManager.getTransaction().begin();
        entityManager.remove(get(idStudent));
        entityManager.getTransaction().commit();
    }

    public Student get(long idStudent){ return entityManager.find(Student.class, idStudent);}

    public void updateStudent(Student student){
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    public List<Student> getAllStudent(){
        TypedQuery<Student> studentTypedQuery = entityManager.createNamedQuery("Student.getAll", Student.class);
        return studentTypedQuery.getResultList();
    }
}
