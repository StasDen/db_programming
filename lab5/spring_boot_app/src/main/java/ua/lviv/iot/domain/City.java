package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

// todo: implement Region
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

    // @ManyToOne(mappedBy = "cities")
    // private List<Region> regions;

    // ===================================
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

//    public List<Region> getRegions() {
//        return regions;
//    }

//    public void setRegions(List<Region> regions) {
//        this.regions = regions;
//    }

    // ===================================
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        City city1 = (City) o;
        return Objects.equals(id, city1.getId()) && Objects.equals(name, city1.getName()) && Objects.equals(regionId, city1.getRegionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, regionId);
    }
}
