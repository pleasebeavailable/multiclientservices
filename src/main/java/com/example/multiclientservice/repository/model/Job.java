package com.example.multiclientservice.repository.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "jobs",fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    public Job() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchase(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
