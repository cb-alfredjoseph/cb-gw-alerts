package com.chargebee.cbgwalerts.service;

import com.chargebee.cbgwalerts.model.DynamicScheduler;
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
}
