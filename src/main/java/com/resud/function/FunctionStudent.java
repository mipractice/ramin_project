package com.resud.function;

import com.resud.controllers.StudentService;
import com.resud.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class FunctionStudent implements StudentService{
    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();

    @Override
    public StudentEntity getByIdStudent(long idStudent) {
        return entityManager.find(StudentEntity.class, idStudent);
    }

    public StudentEntity addStudent(StudentEntity student) {
        entityManager.getTransaction().begin();
        StudentEntity studentAddDB = entityManager.merge(student);
        entityManager.getTransaction().commit();
        return studentAddDB;
    }

    @Override
    public void updateStudent(StudentEntity student) {
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
    public List<StudentEntity> getAllStudent(){
        TypedQuery<StudentEntity> studentTypedQuery = entityManager.createNamedQuery("Student.getAll", StudentEntity.class);
        return studentTypedQuery.getResultList();
    }
}
