package com.chargebee.cbgwalerts.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class PaymentMethod{
    @JsonProperty("merchantDomainList")
    List<MerchantDomain> merchantDomainList = new ArrayList<>();

    public PaymentMethod listMerchantDomains(List<MerchantDomain> merchantDomains) {
        this.merchantDomainList = merchantDomains;
        return this;
    }

    public PaymentMethod addMerchantDomainItem(MerchantDomain merchantDomainsItem) {
        this.merchantDomainList.add(merchantDomainsItem);
        return this;
    }

    public  List<MerchantDomain> getMerchantDomainList() {
       return  this.merchantDomainList;

    }
}
