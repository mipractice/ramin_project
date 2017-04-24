package com.rr.service;

import com.rr.model.Student;

import java.util.List;

public interface StudentService {

    Student getById(long id);

    Student add(Student student);

    void update(Student student);

    void delete(long idStudent);

    List<Student> getAll();
}
