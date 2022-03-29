package com.chargebee.cbgwalerts.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

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
}
