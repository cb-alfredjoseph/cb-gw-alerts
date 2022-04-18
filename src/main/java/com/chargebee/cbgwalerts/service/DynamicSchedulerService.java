package com.chargebee.cbgwalerts.service;

import com.chargebee.cbgwalerts.model.DynamicScheduler;

import java.util.List;


public interface DynamicSchedulerService {
    List<DynamicScheduler> getAllSchedulers();
    void saveScheduler(DynamicScheduler dynamicScheduler);
}
