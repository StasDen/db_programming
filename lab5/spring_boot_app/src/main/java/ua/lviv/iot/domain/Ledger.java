package ua.lviv.iot.domain;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Objects;

@Entity
public class Ledger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "client")
    private String client;

    @Basic
    @Column(name = "order")
    private String order;

    @Basic
    @Column(name = "action")
    private String action;

    @Basic
    @Column(name = "time")
    private Timestamp time;

    @Basic
    @Column(name = "user")
    private String user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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

        Ledger ledger = (Ledger) o;
        return Objects.equals(id, ledger.getId()) && Objects.equals(client, ledger.getClient()) && Objects.equals(order, ledger.getOrder()) && Objects.equals(action, ledger.getAction()) && Objects.equals(time, ledger.getTime()) && Objects.equals(user, ledger.getUser());
    }
}
