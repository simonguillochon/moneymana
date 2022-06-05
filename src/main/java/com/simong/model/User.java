package com.simong.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * An User is an entity containing a wallet responsible of any Order made on the
 * latter. This entity aims to allow authentication in the future.
 * 
 * User (1) <-> (n) Wallet
 * 
 * /!\ This entity does not hold any business logic
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    public String username;

    @OneToMany(mappedBy = "user")
    public Set<Wallet> wallet;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Wallet> getWallet() {
        return this.wallet;
    }

    public void setWallet(Set<Wallet> wallet) {
        this.wallet = wallet;
    }

}
