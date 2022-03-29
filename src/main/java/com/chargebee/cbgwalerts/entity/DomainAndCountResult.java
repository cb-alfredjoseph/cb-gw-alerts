package com.chargebee.cbgwalerts.entity;

public class DomainAndCountResult {
    private long site_id;
    private long count;
    public DomainAndCountResult(long site_id, long count){
        this.site_id = site_id;
        this.count = count;
    }

    public long getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
