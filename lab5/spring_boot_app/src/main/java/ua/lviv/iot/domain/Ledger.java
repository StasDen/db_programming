package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Date;
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
    @Column(name = "ordering")
    private String ordering;

    @Basic
    @Column(name = "action")
    private String action;

    @Basic
    @Column(name = "time")
    private Date time;

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

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
        return Objects.equals(id, ledger.getId()) && Objects.equals(client, ledger.getClient()) && Objects.equals(ordering, ledger.getOrdering()) && Objects.equals(action, ledger.getAction()) && Objects.equals(time, ledger.getTime()) && Objects.equals(user, ledger.getUser());
    }
}
