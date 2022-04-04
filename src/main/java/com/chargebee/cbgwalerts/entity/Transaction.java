package com.chargebee.cbgwalerts.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
@Data
public class Transaction {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="site_id")
    private long site_id;
    @Column(name="business_entity_id")
    private int business_entity_id;
    @Column(name="external_id")
    private int external_id;
    @Column(name="amount_unused")
    private int amount_unused;
    @Column(name="payment_method")
    private int payment_method ;
    @Column(name="gateway")
    private int gateway;
    @Column(name="type")
    private int type;
    @Column(name="currency")
    private int currency;
    @Column(name="card_type_enum")
    private int card_type_enum;
    @Column(name="gw_acc_type")
    private int gw_acc_type;
    @Column(name="imported")
    private boolean imported;
    @Column(name="modified_at")
    private String modified_at;
    @Column(name="fraud_status")
    private int fraud_status;
    @Column(name="status")
    private int status;
    @Column(name="created_at")
    private LocalDateTime created_at;

    public Transaction() {}
}
