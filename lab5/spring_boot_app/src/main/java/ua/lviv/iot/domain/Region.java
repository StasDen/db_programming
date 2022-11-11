package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Region {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Region region = (Region) o;
        return Objects.equals(id, region.getId()) && Objects.equals(name, region.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
