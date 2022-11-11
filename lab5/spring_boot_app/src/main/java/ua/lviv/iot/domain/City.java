package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "region_id")
    private Integer regionId;

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

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        City city = (City) o;
        return Objects.equals(id, city.getId()) && Objects.equals(name, city.getName()) && Objects.equals(regionId, city.getRegionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, regionId);
    }
}
