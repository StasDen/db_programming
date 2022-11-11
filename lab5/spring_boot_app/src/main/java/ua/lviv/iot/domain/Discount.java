package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Discount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "percentage")
    private Integer percentage;

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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Discount discount = (Discount) o;
        return Objects.equals(id, discount.getId()) && Objects.equals(name, discount.getName()) && Objects.equals(percentage, discount.getPercentage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, percentage);
    }
}
