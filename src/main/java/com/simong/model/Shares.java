package com.simong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.simong.model.enums.ShareType;

/**
 * A Shares is an asset entity with its related informations sometimes stored in
 * proper objects.
 * FYI: Up to now, a Shares type can be either crypto or market and is stored in
 * dedicated enum.
 * FYI: Shares slug correponds to market name of this Shares (e.g. ETH, AAPL)
 * 
 * Shares (1) <-> (1) Company
 */

@Entity
@Table(name = "shares")
public class Shares {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "shares")
    private Order order;

    @Column(name = "slug")
    public String slug;

    @Column(name = "shareType")
    public ShareType shareType;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public Company company;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public ShareType getType() {
        return this.shareType;
    }

    public void setType(ShareType shareType) {
        this.shareType = shareType;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
