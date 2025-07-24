package com.udemy.accounts.services.Implementation;

import com.udemy.accounts.constants.*;
import com.udemy.accounts.dto.*;
import com.udemy.accounts.entity.*;
import com.udemy.accounts.exception.*;
import com.udemy.accounts.feignClasses.*;
import com.udemy.accounts.mapper.*;
import com.udemy.accounts.repository.*;
import com.udemy.accounts.services.interfaces.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepo accountRepo;

    private CustomerRepo customerRepo;

    @Autowired
    CardClient cardClient;
    /**
     * @param customerDto -CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepo.findByMobileNumber(customer.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer is already present is this number: " + customer.getMobileNumber());
        }
        customer.setCreatedBy("Omkar");
        customer.setCreatedAt(LocalDateTime.now());
        Customer saveCustomer = customerRepo.save(customer);
        accountRepo.save(createNewAccount(saveCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepo.findByMobileNumber(mobileNumber).orElseThrow(() -> new CustomerNotFountException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountRepo.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new CustomerNotFountException("account", "customerID", mobileNumber));
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapToAccountsDto(accounts, new AccountDto()));
        return customerDto;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepo.findByMobileNumber(mobileNumber).orElseThrow(() -> new CustomerNotFountException("Customer", "mobileNumber", mobileNumber));
        customerRepo.deleteById(customer.getCustomerId());
        accountRepo.deleteByCustomerId(customer.getCustomerId());
        return true;
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(90000000);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Omkar");
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(Constants.SAVING);
        newAccount.setBranchAddress(Constants.ADDRESS);
        return newAccount;

    }

    @Override
    public CardRecordsDTO getCardDetailsUsingFeignClient() {
         return cardClient.getCardDetails();
    }
}