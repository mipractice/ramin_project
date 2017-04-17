package com.resud.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class fxStudent {

    private SimpleLongProperty idStudent;
    private SimpleIntegerProperty ageStudent;
    private SimpleStringProperty nameStudent;
    private SimpleStringProperty emailStudent;

    public fxStudent(long idStudent, int ageStudent, String nameStudent, String emailStudent) {
        this.idStudent = new SimpleLongProperty(idStudent);
        this.ageStudent = new SimpleIntegerProperty(ageStudent);
        this.nameStudent = new SimpleStringProperty(nameStudent);
        this.emailStudent = new SimpleStringProperty(emailStudent);
    }

    public long getIdStudent() {
        return idStudent.get();
    }

    public SimpleLongProperty idStudentProperty() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent.set(idStudent);
    }

    public int getAgeStudent() {
        return ageStudent.get();
    }

    public SimpleIntegerProperty ageStudentProperty() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent.set(ageStudent);
    }

    public String getNameStudent() {
        return nameStudent.get();
    }

    public SimpleStringProperty nameStudentProperty() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent.set(nameStudent);
    }

    public String getEmailStudent() {
        return emailStudent.get();
    }

    public SimpleStringProperty emailStudentProperty() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent.set(emailStudent);
    }
}
