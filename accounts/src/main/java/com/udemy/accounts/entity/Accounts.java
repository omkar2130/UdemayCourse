package com.udemy.accounts.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name="account")
public class Accounts extends BaseEntity {

    private Long customerId;
    @Id
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
