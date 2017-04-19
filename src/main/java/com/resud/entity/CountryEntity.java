package com.resud.entity;

import javax.persistence.*;

@Entity
@Table(name = "country", schema = "Project")
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

    private RegionEntity id_region;

    @ManyToOne(optional = false)
    public RegionEntity getId_region() {
        return id_region;
    }

    public void setId_region(RegionEntity id_region) {
        this.id_region = id_region;
    }
}
