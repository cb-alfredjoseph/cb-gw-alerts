package com.chargebee.cbgwalerts.controllers;

import com.chargebee.cbgwalerts.email.FeedbackService;
import com.chargebee.cbgwalerts.entity.PaymentGateway;
import com.chargebee.cbgwalerts.entity.Transactions;
import com.chargebee.cbgwalerts.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertController {

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/listTransactions")
    public List<Transactions> alert() {
        Transactions transactions = new Transactions();
        return transactionsService.findAllTransactions();
    }

    @PostMapping("/addTransactions")
    public void addTransactions(@RequestBody Transactions transaction) {
        transactionsService.saveTransaction(transaction);
    }

    @GetMapping("/displayTransactions")
    public PaymentGateway getDomainAndCount(@RequestParam("gateway") String gateway_name,
                                            @RequestParam("payment_method") String payment_methodName,
                                            @RequestParam("status") int status) {
        PaymentGateway paymentGateway = transactionsService.returnFinal(gateway_name, payment_methodName, status);
//        List<MerchantDomain> merchantDomainList = null;
//        if (paymentGateway != null && paymentGateway.getPaymentMethodList() != null && paymentGateway.getPaymentMethodList().size() != 0)
//        {
//            merchantDomainList = paymentGateway.getPaymentMethodList().get(0).getMerchantDomainList();
//        }
//
//        Map<String, Object> model = new HashMap<>();
//
//        model.put("gateway", gateway_name);
//        model.put("paymentMethod", payment_methodName);
//        model.put("status", status);
//        model.put("merchantDomainList", merchantDomainList );
//
//
//        feedbackService.sendFeedback(model);
        return paymentGateway;
        //return transactionsRepository.listDomainAndCount(gateway_name,payment_method,status);
    }

}
