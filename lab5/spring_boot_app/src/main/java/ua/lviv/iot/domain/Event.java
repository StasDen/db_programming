package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "animators_num")
    private Integer animatorsNum;

    @Basic
    @Column(name = "visitors_num")
    private Integer visitorsNum;

    @Basic
    @Column(name = "date")
    private String date;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "duration_in_hours")
    private Integer durationInHours;

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

    public Integer getAnimatorsNum() {
        return animatorsNum;
    }

    public void setAnimatorsNum(Integer animatorsNum) {
        this.animatorsNum = animatorsNum;
    }

    public Integer getVisitorsNum() {
        return visitorsNum;
    }

    public void setVisitorsNum(Integer visitorsNum) {
        this.visitorsNum = visitorsNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(Integer durationInHours) {
        this.durationInHours = durationInHours;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer id) {
        this.cityId = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Event event = (Event) o;
        return Objects.equals(id, event.getId()) && Objects.equals(name, event.getName()) && Objects.equals(animatorsNum, event.getAnimatorsNum()) && Objects.equals(visitorsNum, event.getVisitorsNum()) && Objects.equals(date, event.getDate()) && Objects.equals(address, event.getAddress()) && Objects.equals(durationInHours, event.getDurationInHours()) && Objects.equals(cityId, event.getCityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, animatorsNum, visitorsNum, date, address, durationInHours, cityId);
    }
}
