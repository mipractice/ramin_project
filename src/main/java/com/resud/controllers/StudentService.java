package com.resud.controllers;

import com.resud.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    StudentEntity getByIdStudent(long idStudent);

    StudentEntity addStudent(StudentEntity student);

    void updateStudent(StudentEntity student);

    void deleteStudent(long idStudent);

    List<StudentEntity> getAllStudent();

}