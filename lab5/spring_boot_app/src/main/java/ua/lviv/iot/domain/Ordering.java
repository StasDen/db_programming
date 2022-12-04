package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Ordering {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "cost_in_usd")
    private Integer costInUsd;

    @Basic
    @Column(name = "event_id")
    private Integer eventId;

    @Basic
    @Column(name = "discount_id")
    private Integer discountId;

    @Basic
    @Column(name = "client_id")
    private Integer clientId;

    @Basic
    @Column(name = "entertainment_agency_id")
    private Integer entertainmentAgencyId;

    @ManyToMany(mappedBy = "orderings")
    private Set<Client> clients;

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

    public Integer getCostInUsd() {
        return costInUsd;
    }

    public void setCostInUsd(Integer costInUsd) {
        this.costInUsd = costInUsd;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer id) {
        this.discountId = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer id) {
        this.clientId = id;
    }

    public Integer getEntertainmentAgencyId() {
        return entertainmentAgencyId;
    }

    public void setEntertainmentAgencyId(Integer id) {
        this.entertainmentAgencyId = id;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ordering order = (Ordering) o;
        return Objects.equals(id, order.getId()) && Objects.equals(name, order.getName()) && Objects.equals(costInUsd, order.getCostInUsd()) && Objects.equals(eventId, order.getEventId()) && Objects.equals(discountId, order.getDiscountId()) && Objects.equals(clientId, order.getClientId()) && Objects.equals(entertainmentAgencyId, order.getEntertainmentAgencyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, costInUsd, eventId, discountId, clientId, entertainmentAgencyId);
    }
}
