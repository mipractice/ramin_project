package com.resud.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "student", schema = "Project")
public class StudentEntity {
    private int idStudent;
    private String firstName;
    private String secondName;
    private String gender;
    private Timestamp birthday;
    private String phone;
    private String address;

    @Id
    @Column(name = "id_student")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday")
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (idStudent != that.idStudent) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    private Collection<CityEntity> id_student;

    @OneToMany(mappedBy = "id_student")
    public Collection<CityEntity> getId_student() {
        return id_student;
    }

    public void setId_student(Collection<CityEntity> id_student) {
        this.id_student = id_student;
    }
}
