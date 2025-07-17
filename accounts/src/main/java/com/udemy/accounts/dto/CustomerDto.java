package com.udemy.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class CustomerDto {



    @NotEmpty(message = "Name can not be empty ")
    @Size(min = 2, max = 10,message = "Name Shoude be 2-10 letter")
    private String name;

    @NotEmpty(message = "email can not be empty")
    @Email(message = "PLease Enter Valid Email")
    private String email;

    @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile number must be digit")
    private String mobileNumber;
    private AccountDto accountDto;
}
