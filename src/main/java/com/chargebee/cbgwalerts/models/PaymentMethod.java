package com.chargebee.cbgwalerts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.*;
@Data
@ToString
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
