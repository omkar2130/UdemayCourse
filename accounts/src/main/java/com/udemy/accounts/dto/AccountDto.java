package com.udemy.accounts.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class AccountDto {

    @NotEmpty(message = "Account numeber can not null")
    @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile number must be digit")
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
    //
     //
}
