package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ClientCard {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "discount_percentage")
    private Integer discountPercentage;

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

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClientCard clientCard = (ClientCard) o;
        return Objects.equals(id, clientCard.getId()) && Objects.equals(name, clientCard.getName()) && Objects.equals(discountPercentage, clientCard.getDiscountPercentage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, discountPercentage);
    }
}
