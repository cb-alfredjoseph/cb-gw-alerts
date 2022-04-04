package com.chargebee.cbgwalerts.service;

import com.chargebee.cbgwalerts.email.EmailService;
import com.chargebee.cbgwalerts.entity.*;
import com.chargebee.cbgwalerts.model.DomainAndCount;
import com.chargebee.cbgwalerts.model.MerchantDomain;
import com.chargebee.cbgwalerts.model.PaymentGateway;
import com.chargebee.cbgwalerts.model.PaymentMethod;
import com.chargebee.cbgwalerts.repository.TransactionsRepository;
import com.chargebee.cbgwalerts.util.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class TransactionsService {

    private int gatewayId;
    private int paymentMethodId;

    private TransactionsRepository transactionsRepository;
    TransactionsService(){}
    @Autowired
    private EnumService enumService;

    @Autowired
    private EmailService emailService;

    @Autowired
    public TransactionsService(TransactionsRepository transactionsRepository){
        this.transactionsRepository = transactionsRepository;
    }

    public List<Transaction> findAllTransactions(){
        return transactionsRepository.findAll();
    }
    public void saveTransaction(Transaction transaction){
        transactionsRepository.save(transaction);
    }

    public PaymentGateway listPendingTransactions(String gateway_name, String payment_methodName, int status) throws AddressException  {
        LocalDateTime ldt = LocalDateTime.now().minus(1, ChronoUnit.HOURS);
        String gatewayNameUpper = gateway_name.toUpperCase();
        gatewayId =enumService.getGatewayId(gatewayNameUpper);

        String paymentMethodNameUpper = payment_methodName.toUpperCase();
        paymentMethodId = enumService.getPaymentMethodId(paymentMethodNameUpper);

        PaymentGateway paymentGateway = new PaymentGateway();
        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        PaymentMethod paymentMethod = new PaymentMethod();
        List<MerchantDomain> merchantDomainList = new ArrayList<>();
        List<DomainAndCount> domainAndCountList = transactionsRepository.listDomainAndCount(gatewayId,paymentMethodId,status,ldt);

        for(DomainAndCount dc : domainAndCountList){
            MerchantDomain merchantDomain = new MerchantDomain(dc.getCount(),null, dc.getDomainName());
            merchantDomainList.add(merchantDomain);
        }

//        if(merchantDomainList.size()!=0 && merchantDomainList!=null) {
            paymentMethod.listMerchantDomains(merchantDomainList);
            paymentMethodList.add(paymentMethod);
            paymentGateway.listPaymentMethods(paymentMethodList);
            Optional<EnumService.Name> gatewayName = EnumService.Name.get(gatewayId);
            System.out.println(gatewayName.get());


            List<MerchantDomain> merchantDomainListLocal = null;
            if (paymentGateway != null && paymentGateway.getPaymentMethodList() != null && paymentGateway.getPaymentMethodList().size() != 0) {
                merchantDomainListLocal = paymentGateway.getPaymentMethodList().get(0).getMerchantDomainList();
            }
        if(merchantDomainList.size()!=0 && merchantDomainList!=null) {
            Map<String, Object> model = new HashMap<>();

            model.put("gateway", gateway_name);
            model.put("paymentMethod", payment_methodName);
            model.put("status", status);
            model.put("merchantDomainList", merchantDomainListLocal);


            emailService.sendEmail(model);
        }

        return paymentGateway;
    }



}
