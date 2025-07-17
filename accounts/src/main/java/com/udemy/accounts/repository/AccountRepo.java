package com.udemy.accounts.repository;

import com.udemy.accounts.dto.*;
import com.udemy.accounts.entity.*;
import jakarta.transaction.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;


@Repository
public interface AccountRepo extends JpaRepository<Accounts,Long> {
     Optional<Accounts> findByCustomerId(Long customerId);

     @Transactional // if modification fail in between all the transaction get rollback
     @Modifying // tells this method is modifing data in databse to transaction
     void deleteByCustomerId(Long customerId);

}
