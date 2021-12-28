package com.cs320_mts.repository;

import com.cs320_mts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>
{

    public static final String FIND_ACCOUNT_IDS = "SELECT a.accountId FROM Account AS a";
    
    public static final String FIND_ACCOUNTS_BY_USERID = "SELECT a FROM Account as a JOIN a.user u WHERE u.userId = :userId";

    @Query(value = FIND_ACCOUNT_IDS)
    public List<Integer> getAccountIdList();

    @Query(value = FIND_ACCOUNTS_BY_USERID)
    public List<Account> getAccountsByUserId(int userId);


}
