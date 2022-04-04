package com.chargebee.cbgwalerts.controller;

import com.chargebee.cbgwalerts.model.PaymentGateway;
import com.chargebee.cbgwalerts.entity.Transaction;
import com.chargebee.cbgwalerts.service.PaymentsService;
import com.chargebee.cbgwalerts.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import java.util.List;

@RestController
public class AlertController {

    @Autowired
    private TransactionsService transactionsService;


    private PaymentsService paymentsService;
    @Autowired
    AlertController(PaymentsService paymentsService){
        this.paymentsService = paymentsService;
    }

    @GetMapping("/listTransactions")
    public List<Transaction> alert() {
        return transactionsService.findAllTransactions();
    }

    @PostMapping("/addTransactions")
    public void addTransactions(@RequestBody Transaction transaction) {
        transactionsService.saveTransaction(transaction);
    }

    @GetMapping("/transactionsInfo")
    public PaymentGateway transactionsInfoHelper(@RequestParam("gateway") String gateway_name,
                                            @RequestParam("payment_method") String payment_methodName,
                                            @RequestParam("status") int status) throws AddressException {
        PaymentGateway paymentGateway = transactionsService.listPendingTransactions(gateway_name, payment_methodName, status);
        return paymentGateway;
    }

    @GetMapping("/paymentsInfo")
    public PaymentGateway paymentsInfoHelper(@RequestParam("gateway") String gateway_name,
                                            @RequestParam("payment_method") String payment_methodName,
                                            @RequestParam("status") String status) throws AddressException {
        PaymentGateway paymentGateway = paymentsService.listPendingPayments(gateway_name, payment_methodName, status);
        return paymentGateway;
    }

}
