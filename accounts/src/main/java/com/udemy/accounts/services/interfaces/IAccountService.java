package com.udemy.accounts.services.interfaces;

import com.udemy.accounts.dto.*;


public interface IAccountService {
    /**
     *
     * @param customerDto -CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
     CustomerDto fetchAccount(String mobileNumber);
     boolean deleteAccount(String mobileNumber);
     CardRecordsDTO getCardDetailsUsingFeignClient();
}
