package com.chargebee.cbgwalerts.service;

import com.chargebee.cbgwalerts.email.EmailService;
import com.chargebee.cbgwalerts.model.DomainAndCount;
import com.chargebee.cbgwalerts.model.MerchantDomain;
import com.chargebee.cbgwalerts.model.PaymentGateway;
import com.chargebee.cbgwalerts.model.PaymentMethod;
import com.chargebee.cbgwalerts.repository.PaymentsRepository;
import com.chargebee.cbgwalerts.util.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class PaymentsService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private EnumService enumService;

    private PaymentsRepository paymentsRepository;
    @Autowired
    public PaymentsService(PaymentsRepository paymentsRepository){
        this.paymentsRepository = paymentsRepository;
    }
    private int gatewayId;
    private int paymentMethodId;
    private int paymentStatusId;

    public PaymentGateway listPendingPayments(String gateway_name, String payment_methodName, String status) throws AddressException {

        String gatewayNameUpper = gateway_name.toUpperCase();
        gatewayId = enumService.getGatewayId(gatewayNameUpper);
        String paymentMethodNameUpper = payment_methodName.toUpperCase();
        paymentMethodId = enumService.getPaymentMethodId(paymentMethodNameUpper);
        LocalDateTime ldt = LocalDateTime.now().minus(1, ChronoUnit.HOURS);

        String statusNameUpper = status.toUpperCase();
        EnumService.PaymentStatusEnum statusId = EnumService.PaymentStatusEnum.valueOf(statusNameUpper);
        paymentStatusId = statusId.getValue();
        System.out.println("paymentStatusId " + paymentStatusId);

        PaymentGateway paymentGateway = new PaymentGateway();
        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        PaymentMethod paymentMethod = new PaymentMethod();
        List<MerchantDomain> merchantDomainList = new ArrayList<>();
        List<DomainAndCount> domainAndCountResultList = paymentsRepository.listDomainAndCount(gatewayId,paymentMethodId,paymentStatusId,ldt);
        for(DomainAndCount dcr : domainAndCountResultList){
            MerchantDomain merchantDomain = new MerchantDomain(dcr.getCount(),null, dcr.getDomainName());
            merchantDomainList.add(merchantDomain);
        }

        paymentMethod.listMerchantDomains(merchantDomainList);
        paymentMethodList.add(paymentMethod);
        paymentGateway.listPaymentMethods(paymentMethodList);

        List<MerchantDomain> merchantDomainListLocal = null;
        if (paymentGateway != null && paymentGateway.getPaymentMethodList() != null && paymentGateway.getPaymentMethodList().size() != 0)
        {
            merchantDomainListLocal = paymentGateway.getPaymentMethodList().get(0).getMerchantDomainList();
        }

        Map<String, Object> model = new HashMap<>();

        model.put("gateway", gateway_name);
        model.put("paymentMethod", payment_methodName);
        model.put("status", status);
        model.put("merchantDomainList", merchantDomainListLocal );


        emailService.sendFeedback(model);

        return paymentGateway;

    }

}


