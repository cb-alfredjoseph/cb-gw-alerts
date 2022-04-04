package com.chargebee.cbgwalerts.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="credit_cards")
@Data
public class Payment {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="site_id")
    private long site_id;
    @Column(name="payment_method_type")
    private int payment_method ;
    @Column(name="gateway")
    private int gateway;
    @Column(name="status")
    private int status;
    @Column(name="created_at")
    private LocalDateTime created_at;
}
