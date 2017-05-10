package ru.esstu.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * Created by RRM on 08.05.17.
 */
@Entity

@NamedQueries({
        @NamedQuery(name = "StudentImplDao.getAll", query = "SELECT c FROM Student c"),
        @NamedQuery(name = "StudentImplDao.find", query = "SELECT c FROM Student c WHERE c.id = :id")
})
public class Student {
    private int id;
    private String firstname;
    private String surname;
    private String gender;
    @JsonIgnore
    private Date birthday;
    private String address;
    private String phone;
    @JsonIgnore
    private City city;

    public Student() {
    }

    public Student(String gender, Date birthday, String phone, String address, int id, String firstname, String surname, City city) {
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.city = city;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne
    @JoinColumn(name = "city")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (firstname != null ? !firstname.equals(student.firstname) : student.firstname != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (gender != null ? !gender.equals(student.gender) : student.gender != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

//    @Override
//    public String toString() {
//        return "Студент №: " + id + "." +
//                "\n\t\t\t{" +
//                "\n\t\t\t\tФИО: " + surname + " " + firstname +
//                "\n\t\t\t\tПол: " + gender +
//                "\n\t\t\t\tДата рождения: " + birthday +
//                "\n\t\t\t\tАдрес: " + address +
//                "\n\t\t\t\tНомер телефона: " + phone +
//                "\n\t\t\t\tГород: " + city +
//                "\n\t\t\t}";
//    }
}