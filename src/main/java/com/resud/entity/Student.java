package com.resud.entity;

import javax.persistence.*;

/**
 * Created by RRM on 16.04.17.
 */
@Entity
@Table(name = "student")
@NamedQuery(name = "Student.getAll", query = "SELECT c FROM Student c")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idStudent;

    @Column(name = "name", nullable = false, length = 45)
    private String nameStudent;

    @Column(name = "age", length = 3)
    private int ageStudent;

    @Column(name = "email", nullable = false, length = 64)
    private String emailStudent;

    public Student(String nameStudent, int ageStudent, String emailStudent) {
        this.nameStudent = nameStudent;
        this.ageStudent = ageStudent;
        this.emailStudent = emailStudent;
    }
    public Student(){}

    public long getIdStudent() {
        return idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getAgeStudent() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent = ageStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    @Override
    public String toString(){
        return "Студент: [ " +
                "ФИО: '" + nameStudent + '\'' +
                ", Возраст: " + ageStudent +
                ", E-mail: '" + emailStudent + "' ];"
                ;
    }
}
