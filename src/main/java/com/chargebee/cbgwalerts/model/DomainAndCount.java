package com.chargebee.cbgwalerts.model;

public class DomainAndCount {
    private String domainName;
    private long count;
    public DomainAndCount(String domainName, long count){
        this.domainName = domainName;
        this.count = count;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
