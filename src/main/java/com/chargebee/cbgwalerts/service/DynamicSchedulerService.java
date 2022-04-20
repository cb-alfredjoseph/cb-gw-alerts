package com.chargebee.cbgwalerts.service;

import com.chargebee.cbgwalerts.entity.DynamicScheduler;

import java.util.List;


public interface DynamicSchedulerService {
    List<DynamicScheduler> getAllSchedulers();
    void saveScheduler(DynamicScheduler dynamicScheduler);

    DynamicScheduler configureDelayTime(DynamicScheduler dynamicScheduler);
}
