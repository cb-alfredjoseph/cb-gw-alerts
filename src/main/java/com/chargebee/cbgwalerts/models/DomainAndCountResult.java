package com.chargebee.cbgwalerts.models;

public class DomainAndCountResult {
    private String domainName;
    private long count;
    public DomainAndCountResult(String domainName, long count){
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
