package com.chargebee.cbgwalerts;

import com.chargebee.cbgwalerts.configuration.DynamicSchedulerConfiguration;
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
//@EnableScheduling
public class CbGwAlertsApplication {

    @Autowired
    DynamicSchedulerConfiguration dynamicSchedulerConfiguration;

    /*   @Value("${gatewayParam.gateway}")
    private String gatewayName;
    @Value("${gatewayParam.paymentMethod}")
    private String paymentMethod;
    @Value("${gatewayParam.host}")
    private String host;
    @Value("${gatewayParam.status}")
    private int status;
    @Value("${gatewayParam.paymentStatus}")
    private String paymentStatus;
    @Autowired
    private TransactionsService transactionsService;*/
    public static void main(String[] args) {

        SpringApplication.run(CbGwAlertsApplication.class, args);
    }



   /* @Scheduled(fixedDelayString = "${gatewayParam.interval}")
    public PaymentGateway job1() throws InterruptedException {
        System.out.println("The time is : " + new Date());
        RestTemplate restTemplate1 = new RestTemplate();
        PaymentGateway finalresult1= restTemplate1.getForObject(host+"/transactionsInfo?gateway="+gatewayName+"&payment_method="+paymentMethod+"&status="+status,PaymentGateway.class);
        System.out.println("result1 : " + finalresult1.toString());
        //Thread.sleep(1000L);
        return finalresult1;

    }
    @Scheduled(fixedDelayString = "${gatewayParam.interval}")
    public PaymentGateway job2() throws InterruptedException {
        System.out.println("The time is : " + new Date());
        RestTemplate restTemplate2 = new RestTemplate();
        PaymentGateway finalresult2= restTemplate2.getForObject(host+"/paymentsInfo?gateway="+gatewayName+"&payment_method="+paymentMethod+"&status="+paymentStatus,PaymentGateway.class);
        System.out.println("result2 : " + finalresult2.toString());
        //Thread.sleep(1000L);
        return finalresult2;
    }*/

}
