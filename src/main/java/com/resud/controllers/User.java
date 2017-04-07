package com.resud.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by RRM on 07.04.17.
 */
public class User {

    private final int id;
    private final StringProperty name;
    private final StringProperty age;
    private final StringProperty email;

    public User(int id, String name, String age, String email) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
        this.email = new SimpleStringProperty(email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name;
    }

    public String getAge() {
        return age.get();
    }
    public void setAge(String age) {
        this.age.set(age);
    }
    public StringProperty ageProperty() {
        return age;
    }

    public String getEmail() {
        return email.get();
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public StringProperty emailProperty() {
        return email;
    }



}
