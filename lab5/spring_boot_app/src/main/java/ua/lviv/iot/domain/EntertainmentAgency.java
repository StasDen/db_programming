package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class EntertainmentAgency {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "contact_number")
    private String contactNumber;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "animator_id")
    private Integer animatorId;

    @Basic
    @Column(name = "city_id")
    private Integer cityId;

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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAnimatorId() {
        return animatorId;
    }

    public void setAnimatorId(Integer animatorId) {
        this.animatorId = animatorId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntertainmentAgency entertainmentAgency = (EntertainmentAgency) o;
        return Objects.equals(id, entertainmentAgency.getId()) && Objects.equals(name, entertainmentAgency.getName()) && Objects.equals(contactNumber, entertainmentAgency.getContactNumber()) && Objects.equals(address, entertainmentAgency.getAddress()) && Objects.equals(animatorId, entertainmentAgency.getAnimatorId()) && Objects.equals(cityId, entertainmentAgency.getCityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contactNumber, address, animatorId, cityId);
    }
}
