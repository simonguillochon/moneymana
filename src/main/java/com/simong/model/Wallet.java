package com.simong.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A Wallet is an entity corresponding to a specific place where assets - either
 * crypto assets and market shares - are stored.
 * FYI: Wallet name correponds to the wallet name (e.g. PEA, Ledger, Binance).
 * 
 * 
 * User (1) <-> (n) Wallet
 * Wallet (1) <-> (n) Order
 * 
 * /!\ This entity does not hold any business logic
 */

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name")
    public String name;

    @Column(name = "link")
    public String link;

    @OneToMany(mappedBy = "wallet")
    public Set<Order> order;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Order> getOrder() {
        return this.order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

}
