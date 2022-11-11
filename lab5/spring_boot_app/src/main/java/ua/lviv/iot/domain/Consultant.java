package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Consultant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "second_name")
    private String secondName;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @Basic
    @Column(name = "entertainment_agency_id")
    private Integer entertainmentAgencyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getEntertainmentAgencyId() {
        return entertainmentAgencyId;
    }

    public void setEntertainmentAgencyId(Integer entertainmentAgencyId) {
        this.entertainmentAgencyId = entertainmentAgencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Consultant consultant = (Consultant) o;
        return Objects.equals(id, consultant.getId()) && Objects.equals(firstName, consultant.getFirstName()) && Objects.equals(secondName, consultant.getSecondName()) && Objects.equals(phoneNumber, consultant.getPhoneNumber()) && Objects.equals(entertainmentAgencyId, consultant.getEntertainmentAgencyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, phoneNumber, entertainmentAgencyId);
    }
}
