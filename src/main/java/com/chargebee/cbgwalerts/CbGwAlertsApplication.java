package com.chargebee.cbgwalerts;

import com.chargebee.cbgwalerts.entity.PaymentGateway;
import com.chargebee.cbgwalerts.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class CbGwAlertsApplication {
    @Value("${gatewayParam.gateway}")
    private String gatewayName;
//    @Value()
    public static void main(String[] args) {

        SpringApplication.run(CbGwAlertsApplication.class, args);
    }
    @Autowired
    private TransactionsService transactionsService;


    @Scheduled(initialDelay = 1000L, fixedDelay = 20000L)
    public PaymentGateway job() throws InterruptedException {
        System.out.println("The time is : " + new Date());
        //PaymentGateway paymentGateway = transactionsService.returnFinal("chargebee","card",100);
//        System.out.println(paymentGateway);

        RestTemplate restTemplate = new RestTemplate();
        PaymentGateway finalresult= restTemplate.getForObject("http://localhost:8080/displayTransactions?gateway="+gatewayName+"&payment_method=card&status=100",PaymentGateway.class);
        System.out.println("result : " + finalresult.toString());
        return finalresult;
        //Thread.sleep(1000L);
    }

}
