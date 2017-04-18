package com.resud.function;

import com.resud.controllers.StudentService;
import com.resud.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class FunctionStudent implements StudentService{
    private EntityManager entityManager = Persistence.createEntityManagerFactory("CRUD").createEntityManager();

    @Override
    public Student getByIdStudent(long idStudent) {
        return entityManager.find(Student.class, idStudent);
    }

    public Student addStudent(Student student) {
        entityManager.getTransaction().begin();
        Student studentAddDB = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return studentAddDB;
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteStudent(long idStudent){
        entityManager.getTransaction().begin();
        entityManager.remove(getByIdStudent(idStudent));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Student> getAllStudent(){
        TypedQuery<Student> studentTypedQuery = entityManager.createNamedQuery("Student.getAll", Student.class);
        return studentTypedQuery.getResultList();
    }
}
