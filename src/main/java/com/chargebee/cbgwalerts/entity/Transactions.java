package com.chargebee.cbgwalerts.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="transactions")
@Data
public class Transactions {

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
//    @Column(name="created_at")
//    private DateTimeFormat created_at;

    public Transactions() {

    }
//    public Transactions(int id, int site_id, int business_entity_id, int external_id, int amount_unused) {
//        this.id = id;
//        this.site_id = site_id;
//        this.business_entity_id = business_entity_id;
//        this.external_id = external_id;
//        this.amount_unused = amount_unused;
//    }

//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Column(name="site_id")
//    public int getSite_id() {
//        return site_id;
//    }
//
//    public void setSite_id(int site_id) {
//        this.site_id = site_id;
//    }
//
//    @Column(name="business_entity_id")
//    public int getBusiness_entity_id() {
//        return business_entity_id;
//    }
//
//    public void setBusiness_entity_id(int business_entity_id) {
//        this.business_entity_id = business_entity_id;
//    }
//
//    @Column(name="external_id")
//    public int getExternal_id() {
//        return external_id;
//    }
//
//    public void setExternal_id(int external_id) {
//        this.external_id = external_id;
//    }
//
//    @Column(name="amount_unused")
//    public int getAmount_unused() {
//        return amount_unused;
//    }
//
//    public void setAmount_unused(int amount_unused) {
//        this.amount_unused = amount_unused;
//    }
//
//    @Override
//    public String toString() {
//        return "Transactions{" +
//                "id=" + id +
//                ", site_id=" + site_id +
//                ", business_entity_id=" + business_entity_id +
//                ", external_id=" + external_id +
//                ", amount_unused=" + amount_unused +
//                '}';
//    }
}
