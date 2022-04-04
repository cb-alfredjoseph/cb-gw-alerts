package com.chargebee.cbgwalerts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantDomain{
    @JsonProperty("count")
    private long count;
    @JsonProperty("link")
    private String link;
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MerchantDomain() {
    }
    public MerchantDomain(long count, String link, String name){
        this.count = count;
        this.link = link;
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return "MerchantDomain{" +
                "count=" + count +
                ", link='" + link + '\'' +
                '}';
    }

}
