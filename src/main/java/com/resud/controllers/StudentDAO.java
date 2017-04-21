package com.resud.controllers;

import com.resud.entity.Student;

import java.util.List;

public interface StudentDAO {

    Student getByIdStudent(long idStudent);

    Student addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(long idStudent);

    List<Student> getAllStudent();

}
