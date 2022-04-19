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

    @Column(name="days")
    private long days;

    @Column(name="hours")
    private long hours;

    @Column(name="minutes")
    private long minutes;

    @Column(name="seconds")
    private long seconds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public long getHours() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }
}
