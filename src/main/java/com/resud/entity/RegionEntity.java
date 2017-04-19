package com.resud.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "region", schema = "Project")
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

    private Collection<CountryEntity> id_region;

    @OneToMany(mappedBy = "id_region")
    public Collection<CountryEntity> getId_region() {
        return id_region;
    }

    public void setId_region(Collection<CountryEntity> id_region) {
        this.id_region = id_region;
    }

    private CityEntity id_city;

    @ManyToOne(optional = false)
    public CityEntity getId_city() {
        return id_city;
    }

    public void setId_city(CityEntity id_city) {
        this.id_city = id_city;
    }
}
