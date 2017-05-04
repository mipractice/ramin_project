package ru.esstu.ws.service;

import ru.esstu.se.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public static List<Student> getAll() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Имя", "Фамилия"));
        students.add(new Student(2, "Имя", "Фамилия"));
        students.add(new Student(3, "Имя", "Фамилия"));
        return students;
    }
}
