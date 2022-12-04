package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Client {
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
    @Column(name = "client_card_id")
    private Integer clientCardId;

    @ManyToMany
    @JoinTable(name = "client_ordering", schema = "my_library", joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "ordering_id", referencedColumnName = "id", nullable = false))
    private Set<Ordering> orderings;

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

    public Integer getClientCardId() {
        return clientCardId;
    }

    public void setClientCardId(Integer clientCardId) {
        this.clientCardId = clientCardId;
    }

    public Set<Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(Set<Ordering> orderings) {
        this.orderings = orderings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Client client = (Client) o;
        return Objects.equals(id, client.getId()) && Objects.equals(firstName, client.getFirstName()) && Objects.equals(secondName, client.getSecondName()) && Objects.equals(phoneNumber, client.getPhoneNumber()) && Objects.equals(clientCardId, client.getClientCardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, phoneNumber, clientCardId);
    }
}
