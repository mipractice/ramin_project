package ru.esstu.db.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by RRM on 08.05.17.
 */
@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CityDaoImpl.getAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "CityDaoImpl.find", query = "SELECT c FROM City c WHERE c.id = :id")
})
public class City {
    private int id;
    private String name;
    private Region region;
    private Collection<Student> students;

    public City() {
    }

    public City(int id) {
        this.id = id;
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(int id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
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

    @ManyToOne
    @JoinColumn(name = "region")
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @OneToMany(mappedBy = "city")
    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;

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
