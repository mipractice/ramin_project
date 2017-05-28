package ru.esstu.db.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

/**
 * Created by RRM on 08.05.17.
 */
@Entity
@XmlRootElement(name = "Region")
@NamedQueries({
        @NamedQuery(name = "RegionDaoImpl.getAll", query = "SELECT c FROM Region c"),
        @NamedQuery(name = "RegionDaoImpl.find", query = "SELECT c FROM Region c WHERE c.id = :id")
})
public class Region {
    private int id;
    private String name;
    private Collection<City> cities;
    private Country country;

    public Region() {
    }

    public Region(int id) {
        this.id = id;
    }

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Region(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Id
    @Column(name = "id")
    @XmlElement(name = "idRegion")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    @XmlElement(name = "nameRegion")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
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

    @Override
    public String toString() {
        return name;
    }
}
