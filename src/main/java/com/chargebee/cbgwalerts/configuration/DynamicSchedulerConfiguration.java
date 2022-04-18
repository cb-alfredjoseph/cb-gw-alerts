package com.chargebee.cbgwalerts.configuration;

import com.chargebee.cbgwalerts.model.DynamicScheduler;
import com.chargebee.cbgwalerts.model.PaymentGateway;
import com.chargebee.cbgwalerts.repository.DynamicSchedulerRepository;
import com.chargebee.cbgwalerts.service.TransactionsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class DynamicSchedulerConfiguration implements SchedulingConfigurer {
    @Autowired
    DynamicSchedulerRepository dynamicSchedulerRepository;

    @Value("${gatewayParam.gateway}")
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
    private TransactionsService transactionsService;

/*
    @Scheduled(fixedDelay = 2000)
    public void job1() throws InterruptedException {
        System.out.println("The time is : " + new Date());
        RestTemplate restTemplate1 = new RestTemplate();
        PaymentGateway finalist2= restTemplate1.getForObject(host+"/transactionsInfo?gateway="+gatewayName+"&payment_method="+paymentMethod+"&status="+status,PaymentGateway.class);
        System.out.println("result1 : " + finalist2.toString());

        //return finalist2;
    }
    @Scheduled(fixedDelay = 2000)
    public void job2() throws InterruptedException {
        System.out.println("The time is : " + new Date());
        RestTemplate restTemplate2 = new RestTemplate();
        PaymentGateway finalist3= restTemplate2.getForObject(host+"/paymentsInfo?gateway="+gatewayName+"&payment_method="+paymentMethod+"&status="+paymentStatus,PaymentGateway.class);
        System.out.println("result2 : " + finalist3.toString());
        //return finalist3;
    }

  @Scheduled(fixedDelay = 2000)
    public void job_run() throws InterruptedException  {
        DynamicSchedulerConfiguration dynamicSchedulerConfiguration1 = new DynamicSchedulerConfiguration();
        dynamicSchedulerConfiguration1.job2();
*/
/*      DynamicSchedulerConfiguration dynamicSchedulerConfiguration2 = new DynamicSchedulerConfiguration();
        paymentGateway = dynamicSchedulerConfiguration1.job1();
        dynamicSchedulerConfiguration2.job2();*//*


    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

    }
*/


    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(
                new Runnable() {

                    @SneakyThrows
                    @Override
                    public void run() {

                        Runnable runnable2 = new Runnable() {
                            public void run() {
                                //Code here
                                System.out.println("The time is : " + new Date());
                                RestTemplate restTemplate1 = new RestTemplate();
                                PaymentGateway finalist2 = restTemplate1.getForObject(host + "/transactionsInfo?gateway=" + gatewayName + "&payment_method=" + paymentMethod + "&status=" + status, PaymentGateway.class);
                                System.out.println("result1 : " + finalist2.toString());

                                RestTemplate restTemplate2 = new RestTemplate();
                                PaymentGateway finalist3 = restTemplate2.getForObject(host + "/paymentsInfo?gateway=" + gatewayName + "&payment_method=" + paymentMethod + "&status=" + paymentStatus, PaymentGateway.class);
                                System.out.println("result2 : " + finalist3.toString());

                            }
                        };
                        (new Thread(runnable2)).start();


                    }
                },
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext context) {
                        Optional<Date> lastCompletionTime =
                                Optional.ofNullable(context.lastCompletionTime());
                        Optional<DynamicScheduler> dynamicScheduler = dynamicSchedulerRepository.findById(1L);
                        Instant nextExecutionTime =
                                lastCompletionTime.orElseGet(Date::new).toInstant()
                                        .plusMillis(dynamicScheduler.isPresent() ? dynamicScheduler.get().getDelayTime() : 2000);
                        return Date.from(nextExecutionTime);
                    }
                }
        );
    }
}
