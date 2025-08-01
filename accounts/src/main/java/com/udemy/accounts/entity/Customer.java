package com.udemy.accounts.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;
    private String email;
    private String mobileNumber;
}
