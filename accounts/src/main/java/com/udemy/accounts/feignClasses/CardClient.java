package com.udemy.accounts.feignClasses;

import com.udemy.accounts.dto.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "http://localhost:8081", name="card-service")
public interface CardClient {

    @GetMapping("/card/v1/getAccountDetails")
    CardRecordsDTO getCardDetails();
}
