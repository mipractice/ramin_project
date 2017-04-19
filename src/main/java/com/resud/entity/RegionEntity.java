package com.resud.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by RRM on 19.04.17.
 */
@Entity
@Table(name = "region", schema = "Project", catalog = "")
public class RegionEntity {
    private int idRegion;
    private String regionName;

    @Id
    @Column(name = "id_region")
    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    @Basic
    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionEntity that = (RegionEntity) o;

        if (idRegion != that.idRegion) return false;
        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRegion;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }

    private StudentEntity id_student;

    @ManyToOne(optional = false)
    public StudentEntity getId_student() {
        return id_student;
    }

    public void setId_student(StudentEntity id_student) {
        this.id_student = id_student;
    }

    private Collection<CityEntity> id_city;

    @OneToMany(mappedBy = "id_city")
    public Collection<CityEntity> getId_city() {
        return id_city;
    }

    public void setId_city(Collection<CityEntity> id_city) {
        this.id_city = id_city;
    }
}
