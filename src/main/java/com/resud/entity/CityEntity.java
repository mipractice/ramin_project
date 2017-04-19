package com.resud.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by RRM on 19.04.17.
 */
@Entity
@Table(name = "city", schema = "Project", catalog = "")
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

    private RegionEntity id_city;

    @ManyToOne(optional = false)
    public RegionEntity getId_city() {
        return id_city;
    }

    public void setId_city(RegionEntity id_city) {
        this.id_city = id_city;
    }

    private Collection<CountryEntity> id_country;

    @OneToMany(mappedBy = "id_country")
    public Collection<CountryEntity> getId_country() {
        return id_country;
    }

    public void setId_country(Collection<CountryEntity> id_country) {
        this.id_country = id_country;
    }
}
