package com.chargebee.cbgwalerts.util;

import com.chargebee.cbgwalerts.service.TransactionsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Component
public class EnumService {

    public enum Name {
        CHARGEBEE(100), STRIPE(700), WEPAY(250), BRAINTREE(300), AUTHORIZE_NET(1200), PAYPAL_PRO(600), PIN(1500), EWAY(1100), EWAY_RAPID(1110), WORLDPAY(500), BALANCED_PAYMENTS(1300),
        BAMBORA(1400), BLUEPAY(2300), ELAVON(1800), FIRST_DATA_GLOBAL(2200), HDFC(1000), MIGS(1700), NMI(2000), INGENICO_EPAYMENTS(900), PAYMILL(1600), PAYPAL_PAYFLOW_PRO(2100), SAGE_PAY(1900),
        TCO(400), WIRECARD(800), AMAZON_PAYMENTS(5000), PAYPAL_EXPRESS_CHECKOUT(6000), GOCARDLESS(7000), ADYEN(7100), ORBITAL(8000), MONERIS_US(9000), MONERIS(10000), BLUESNAP(11000), CYBERSOURCE(11100),
        VANTIV(4000), CHECKOUT_COM(4100), PAYPAL(4200), INGENICO_DIRECT(4300), EXACT(4400), MOLLIE(4500), QUICKBOOKS(4700), RAZORPAY(4600), NOT_APPLICABLE(10);

        public final int id;

        Name(int value) {
            this.id = value;
        }

        public int getValue() {
            return id;
        }

        public static Optional<Name> get(int num) {
            return Arrays.stream(Name.values())
                    .filter(name -> name.id == num)
                    .findFirst();
        }
    }

    public enum PaymentMethodEnum{
        CARD(100),CASH(200),CHECK(300),CHARGEBACK(700),BANK_TRANSFER(400),AMAZON_PAYMENTS(500),PAYPAL_EXPRESS_CHECKOUT(600),DIRECT_DEBIT(800),ALIPAY(1000),UNIONPAY(1100),APPLE_PAY(1200),WECHAT_PAY(1300),ACH_CREDIT(1400),SEPA_CREDIT(1500),IDEAL(1700),GOOGLE_PAY(1600),SOFORT(1800),BANCONTACT(1900),GIROPAY(2000),DOTPAY(2100),OTHER(999),APP_STORE(2200),UPI(2300),NETBANKING_EMANDATES(2400);

        public final int id;
        PaymentMethodEnum(int value){
            this.id = value;
        }
        public int getValue() {
            return id;
        }
        public static Optional<PaymentMethodEnum> get(int num) {
            return Arrays.stream(PaymentMethodEnum.values())
                    .filter(paymentMethodValue -> paymentMethodValue.id == num)
                    .findFirst();
        }
    }

    public enum PaymentStatusEnum {
        NO_CARD(100), VALID(200), EXPIRING(300), EXPIRED(400), PENDING_VERIFICATION(500), INVALID(600);

        private final int id;

        PaymentStatusEnum(int value) {
            this.id = value;
        }

        public int getValue() {
            return id;
        }

        public static Optional<PaymentStatusEnum> get(int num) {
            return Arrays.stream(PaymentStatusEnum.values())
                    .filter(paymentMethodValue -> paymentMethodValue.id == num)
                    .findFirst();
        }
    }
    public int getGatewayId(String gatewayNameUpper){
        Name gwId = Name.valueOf(gatewayNameUpper);
        int gatewayId = gwId.getValue();
        return gatewayId;
    }

    public int getPaymentMethodId(String paymentMethodNameUpper){
        PaymentMethodEnum paymentType = PaymentMethodEnum.valueOf(paymentMethodNameUpper);
        int paymentMethodId = paymentType.getValue();
        return paymentMethodId;
    }


}
