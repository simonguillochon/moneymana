package com.simong.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * An Order is an entity linked to the action of buy or sell a Shares. When the
 * user makes an order, its action is stored in this entity.
 * FYI: Order type is a boolean because it can be either "buying" or "selling".
 * 
 * Order (1) <-> (1) Shares (1) <-> (1) Company
 * Order (n) <-> (1) Wallet (n) <-> (1) User
 */

@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @Column(name = "type")
    public boolean type;

    @Column(name = "created_at")
    public LocalDateTime created_at;

    @OneToOne
    @JoinColumn(name = "share_id", referencedColumnName = "id")
    public Shares shares;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public boolean isType() {
        return this.type;
    }

    public boolean getType() {
        return this.type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return this.created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Shares getShare() {
        return this.shares;
    }

    public void setShare(Shares shares) {
        this.shares = shares;
    }

}
