package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PartyAnimator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;

    @Basic
    @Column(name = "unique_performance")
    private String uniquePerformance;

    @Basic
    @Column(name = "work_experience_in_years")
    private Integer workExperienceInYears;

    @Basic
    @Column(name = "order_id")
    private Integer orderId;

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
        return lastName;
    }

    public void setSecondName(String secondName) {
        this.lastName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniquePerformance() {
        return uniquePerformance;
    }

    public void setUniquePerformance(String uniquePerformance) {
        this.uniquePerformance = uniquePerformance;
    }

    public Integer getWorkExperienceInYears() {
        return workExperienceInYears;
    }

    public void setWorkExperienceInYears(Integer workExperienceInYears) {
        this.workExperienceInYears = workExperienceInYears;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PartyAnimator partyAnimator = (PartyAnimator) o;
        return Objects.equals(id, partyAnimator.getId()) && Objects.equals(firstName, partyAnimator.getFirstName()) && Objects.equals(lastName, partyAnimator.getSecondName()) && Objects.equals(phoneNumber, partyAnimator.getPhoneNumber()) && Objects.equals(uniquePerformance, partyAnimator.getUniquePerformance()) && Objects.equals(workExperienceInYears, partyAnimator.getWorkExperienceInYears()) && Objects.equals(orderId, partyAnimator.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, uniquePerformance, workExperienceInYears, orderId);
    }
}
