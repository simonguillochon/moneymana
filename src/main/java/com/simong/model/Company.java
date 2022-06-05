package com.simong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * A Company is an entity corresponding to the organisation behind an asset.
 * e.g. Ethereum is the Company of ETH, Apple is the Company of AAPL
 * 
 * Company (1) <-> (1) Shares
 */

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "company")
    private Shares shares;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shares getShare() {
        return this.shares;
    }

    public void setShare(Shares shares) {
        this.shares = shares;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
