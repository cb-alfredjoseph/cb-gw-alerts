package com.chargebee.cbgwalerts.controllers;

import com.chargebee.cbgwalerts.entity.*;
import com.chargebee.cbgwalerts.repository.TransactionsRepository;
//import com.chargebee.cbgwalerts.service.TransactionsService;
import com.chargebee.cbgwalerts.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AlertController {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/listTransactions")
    public List<Transactions> alert(){
        Transactions transactions = new Transactions();
        return transactionsService.findAllTransactions();
    }

    @PostMapping("/addTransactions")
    public void  addTransactions(@RequestBody Transactions transaction){
        transactionsService.saveTransaction(transaction);
    }

    @GetMapping("/displayTransactions")
    public PaymentGateway getDomainAndCount(@RequestParam("gateway") String gateway_name,
                                                            @RequestParam("payment_method") String payment_methodName,
                                                            @RequestParam("status") int status){
        PaymentGateway paymentGateway = transactionsService.returnFinal(gateway_name,payment_methodName,status);

        return paymentGateway;
        //return transactionsRepository.listDomainAndCount(gateway_name,payment_method,status);
    }

}
