package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import com.cs320_mts.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cs320_mts.service.UserService;

import java.util.Date;

@SpringBootTest
public class TestUserService
{
    @Autowired
    UserService userService;

    @Test
    public void testCreateUser()
    {

        User user = new User("Kerem","Ersan",12345,"07-04-2000","35007269396","kerem.ersan@ozu.edu.tr","5057656825");

        Account account = new Account(300,user);
        user.getAccounts().add(account);

        Account account2 = new Account(200,user);
        user.getAccounts().add(account2);

        Transaction transaction = new Transaction(new Date(),100,account.getAccountId(), account2.getAccountId());
        account.getTransactions().add(transaction);
        userService.save(user);





    }
}
