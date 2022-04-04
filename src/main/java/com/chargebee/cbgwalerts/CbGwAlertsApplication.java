package com.chargebee.cbgwalerts;

import com.chargebee.cbgwalerts.model.PaymentGateway;
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
    @Value("${gatewayParam.paymentMethod}")
    private String paymentMethod;
    @Value("${gatewayParam.host}")
    private String host;
//    @Value("${gatewayParam.interval}")
//    private String interval;

    //    @Value()
    public static void main(String[] args) {
        SpringApplication.run(CbGwAlertsApplication.class, args);
    }
    @Autowired
    private TransactionsService transactionsService;


    @Scheduled(fixedDelayString = "${gatewayParam.interval}")
    public PaymentGateway job1() throws InterruptedException {
        System.out.println("The time is : " + new Date());
        //PaymentGateway paymentGateway = transactionsService.returnFinal("chargebee","card",100);
//        System.out.println(paymentGateway);

        RestTemplate restTemplate1 = new RestTemplate();
//        PaymentGateway finalresult1= restTemplate.getForObject("http://localhost:8080/displayTransactions?gateway="+gatewayName+"&payment_method=card&status=100",PaymentGateway.class);
        PaymentGateway finalresult1= restTemplate1.getForObject(host+"/transactionsInfo?gateway="+gatewayName+"&payment_method="+paymentMethod+"&status=100",PaymentGateway.class);
        System.out.println("result1 : " + finalresult1.toString());
        Thread.sleep(1000L);
        return finalresult1;

    }

    @Scheduled(fixedDelayString = "${gatewayParam.interval}")
    public PaymentGateway job2() throws InterruptedException {
        System.out.println("The time is : " + new Date());
        RestTemplate restTemplate2 = new RestTemplate();
        PaymentGateway finalresult2= restTemplate2.getForObject(host+"/paymentsInfo?gateway="+gatewayName+"&payment_method="+paymentMethod+"&status=valid",PaymentGateway.class);
        System.out.println("result2 : " + finalresult2.toString());
        Thread.sleep(1000L);
        return finalresult2;
    }


}
