package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class PartyAnimatorCopy {
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
    @Column(name = "phone_number_old")
    private String phoneNumberOld;

    @Basic
    @Column(name = "phone_number_updated")
    private String phoneNumberUpd;

    @Basic
    @Column(name = "unique_performance")
    private String uniquePerformance;

    @Basic
    @Column(name = "work_experience_in_years")
    private Integer workExperienceInYears;

    @Basic
    @Column(name = "order_id")
    private Integer orderId;

    @Basic
    @Column(name = "action")
    private String action;

    @Basic
    @Column(name = "time_stamp")
    private Date timeStamp;

    @Basic
    @Column(name = "user")
    private String user;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumberOld() {
        return phoneNumberOld;
    }

    public void setPhoneNumberOld(String phoneNumber) {
        this.phoneNumberOld = phoneNumber;
    }

    public String getPhoneNumberUpd() {
        return phoneNumberUpd;
    }

    public void setPhoneNumberUpd(String phoneNumberUpd) {
        this.phoneNumberUpd = phoneNumberUpd;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PartyAnimatorCopy partyAnimatorCopy = (PartyAnimatorCopy) o;
        return Objects.equals(id, partyAnimatorCopy.getId()) && Objects.equals(firstName, partyAnimatorCopy.getFirstName()) && Objects.equals(lastName, partyAnimatorCopy.getLastName()) && Objects.equals(phoneNumberOld, partyAnimatorCopy.getPhoneNumberOld()) && Objects.equals(phoneNumberUpd, partyAnimatorCopy.getPhoneNumberUpd()) && Objects.equals(uniquePerformance, partyAnimatorCopy.getUniquePerformance()) && Objects.equals(workExperienceInYears, partyAnimatorCopy.getWorkExperienceInYears()) && Objects.equals(orderId, partyAnimatorCopy.getOrderId()) && Objects.equals(action, partyAnimatorCopy.getAction()) && Objects.equals(timeStamp, partyAnimatorCopy.getTimeStamp()) && Objects.equals(user, partyAnimatorCopy.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumberOld, phoneNumberUpd, uniquePerformance, workExperienceInYears, orderId, action, timeStamp, user);
    }
}
