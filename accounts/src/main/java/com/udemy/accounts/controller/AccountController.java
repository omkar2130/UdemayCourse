package com.udemy.accounts.controller;


import com.udemy.accounts.constants.*;
import com.udemy.accounts.dto.*;
import com.udemy.accounts.services.interfaces.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountController {
    @Autowired
    IAccountService accountService;
    @Value("${value.a}")
    int aa;
    @PostMapping("/createAccount")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
            accountService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(Constants.STATUS_201,Constants.MASSAGE_201));
    }

    @GetMapping("/fatch/{mobileNumber}")
    public ResponseEntity<CustomerDto> fatchAccountDetails(@PathVariable(value = "mobileNumber")  String mobileNumber){
        CustomerDto customerDto= accountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber){
        boolean isDeleted=accountService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(Constants.STATUS_200,Constants.STATUS_200));
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(Constants.STATUS_500,Constants.STATUS_500));
        }
    }

    @GetMapping("/getDataFromCardService")
    public ResponseEntity<CardRecordsDTO> getDataFromCardService() {
       CardRecordsDTO cardRecordsDTO= accountService.getCardDetailsUsingFeignClient();
        return ResponseEntity.status(HttpStatus.OK).body(cardRecordsDTO);
    }
}

