package ru.esstu.db.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Collection;

/**
 * Created by RRM on 08.05.17.
 */
@Entity
@XmlRootElement(name = "Country")
@NamedQueries({
        @NamedQuery(name = "CountryDaoImpl.getAll", query = "SELECT c FROM Country c"),
        @NamedQuery(name = "CountryDaoImpl.find", query = "SELECT c FROM Country c WHERE c.id = :id")
})
public class Country {

    private int id;
    private String name;
    private Collection<Region> regions;

    public Country() {
    }

    public Country(int id) {
        this.id = id;
    }

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    @XmlElement(name = "idCountry")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    @XmlElement(name = "nameCountry")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    @OneToMany(mappedBy = "country")
    public Collection<Region> getRegions() {
        return regions;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;

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
