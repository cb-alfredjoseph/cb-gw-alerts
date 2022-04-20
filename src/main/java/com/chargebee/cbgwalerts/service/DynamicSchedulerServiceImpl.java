package com.chargebee.cbgwalerts.service;

import com.chargebee.cbgwalerts.entity.DynamicScheduler;
import com.chargebee.cbgwalerts.repository.DynamicSchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicSchedulerServiceImpl implements DynamicSchedulerService{

    @Autowired
    private DynamicSchedulerRepository dynamicSchedulerRepository;
    @Override
    public List<DynamicScheduler> getAllSchedulers() {
        return dynamicSchedulerRepository.findAll();
    }

    @Override
    public void saveScheduler(DynamicScheduler dynamicScheduler) {
        dynamicScheduler.setId(1);
        this.dynamicSchedulerRepository.save(dynamicScheduler);
    }

    @Override
    public DynamicScheduler configureDelayTime(DynamicScheduler dynamicScheduler){
        long daysToSeconds = dynamicScheduler.getDays()*24*60*60;
        long  hoursToSeconds=dynamicScheduler.getHours()*60*60;
        long  minutesToSeconds=dynamicScheduler.getMinutes()*60;
        long secondsToSeconds=dynamicScheduler.getSeconds();

        long delayTimeInSeconds=daysToSeconds+ hoursToSeconds+minutesToSeconds+secondsToSeconds;
        //  dynamicScheduler.setDelayTime(0);
        dynamicScheduler.setDelayTime(delayTimeInSeconds);

        /*System.out.println(dynamicScheduler.getDelayTime());
        System.out.println(daysToSeconds);
        System.out.println(hoursToSeconds);
        System.out.println(minutesToSeconds);
        System.out.println(secondsToSeconds);*/
        return dynamicScheduler;
    }
}
