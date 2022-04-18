package com.chargebee.cbgwalerts.model;

import javax.persistence.*;

@Entity
@Table(name="dynamic_scheduler")
public class DynamicScheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "delay_time")
    private long delayTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }
}
