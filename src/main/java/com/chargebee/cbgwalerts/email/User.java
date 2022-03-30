package com.chargebee.cbgwalerts.email;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
}
