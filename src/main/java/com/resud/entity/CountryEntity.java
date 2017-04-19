package com.resud.entity;

import javax.persistence.*;

/**
 * Created by RRM on 19.04.17.
 */
@Entity
@Table(name = "country", schema = "Project", catalog = "")
public class CountryEntity {
    private int idCountry;
    private String countryName;

    @Id
    @Column(name = "id_country")
    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    @Basic
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (idCountry != that.idCountry) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCountry;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    private CityEntity id_country;

    @ManyToOne(optional = false)
    public CityEntity getId_country() {
        return id_country;
    }

    public void setId_country(CityEntity id_country) {
        this.id_country = id_country;
    }
}
