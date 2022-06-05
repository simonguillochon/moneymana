package com.simong.repository;

import javax.enterprise.context.ApplicationScoped;

import com.simong.model.Company;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {

    public Company findByName(String name) {
        return find("name", name).firstResult();
    }

    public Company findBySlug(String slug) {
        return find("slug", slug).firstResult();
    }

    public void deleteCompanyByName(String name) {
        delete("name", name);
    }

    public void deleteCompanyBySlug(String slug) {
        delete("slug", slug);
    }
}
