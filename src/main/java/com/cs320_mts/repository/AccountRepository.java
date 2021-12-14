package com.cs320_mts.repository;

import com.cs320_mts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>
{
//    @Query("select a from Account a where a.accountId=?1")
//    public Account checkAccountBalanceById(int id);

}
