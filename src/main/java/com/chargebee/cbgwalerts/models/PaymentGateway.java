package com.chargebee.cbgwalerts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.*;
@ToString
@Data
public class PaymentGateway {
    @JsonProperty("paymentMethodList")
    List<PaymentMethod> paymentMethodList = new ArrayList<>();

    public PaymentGateway listPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethodList = paymentMethods;
        return this;
    }

    public PaymentGateway addPaymentMethodItem(PaymentMethod paymentMethodsItem) {
        this.paymentMethodList.add(paymentMethodsItem);
        return this;
    }
    public   List<PaymentMethod> getPaymentMethodList() {
        return  this.paymentMethodList;

    }

}
