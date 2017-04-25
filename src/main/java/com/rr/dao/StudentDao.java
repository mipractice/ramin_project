package com.rr.dao;

import com.rr.model.Student;

import java.util.List;

public interface StudentDao {

    Student getById(long id);

    Student add(Student student);

    void update(Student student);

    void delete(long id);

    List<Student> getAll();
}
