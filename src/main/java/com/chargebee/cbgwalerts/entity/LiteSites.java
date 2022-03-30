package com.chargebee.cbgwalerts.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lite_sites")
@Data
public class LiteSites {
    @Id
    @Column(name = "id")
    private long site_id;
    @Column(name = "domain")
    private String domain;

    public long getSite_id() {
        return site_id;
    }

    public void setSite_id(long site_id) {
        this.site_id = site_id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
