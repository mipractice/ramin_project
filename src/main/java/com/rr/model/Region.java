package com.rr.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "region", schema = "Student")
@NamedQuery(name = "RegionDaoImpl.getAll", query = "SELECT r FROM Region r")
public class Region {
    private int id;
    private String name;
    private Collection<City> cities;
    private Country country;

    public Region(){}

    public Region(int id) {
        this.id = id;
    }

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (id != region.id) return false;
        if (name != null ? !name.equals(region.name) : region.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "region")
    public Collection<City> getCities() {
        return cities;
    }

    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }

    @ManyToOne
    @JoinColumn(name = "country")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return name;
    }
}
