package com.udemy.accounts.services.interfaces;

import com.udemy.accounts.dto.*;


public interface IAccountService {
    /**
     *
     * @param customerDto -CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
    public CustomerDto fetchAccount(String mobileNumber);
    public boolean deleteAccount(String mobileNumber);
}
