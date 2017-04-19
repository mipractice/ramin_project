package com.resud.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city", schema = "Project")
public class CityEntity {
    private int idCity;
    private String cityName;

    @Id
    @Column(name = "id_city")
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (idCity != that.idCity) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCity;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    private Collection<RegionEntity> id_city;

    @OneToMany(mappedBy = "id_city")
    public Collection<RegionEntity> getId_city() {
        return id_city;
    }

    public void setId_city(Collection<RegionEntity> id_city) {
        this.id_city = id_city;
    }

    private StudentEntity id_student;

    @ManyToOne(optional = false)
    public StudentEntity getId_student() {
        return id_student;
    }

    public void setId_student(StudentEntity id_student) {
        this.id_student = id_student;
    }
}
