package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import com.cs320_mts.model.User;
import com.cs320_mts.repository.AccountRepository;
import com.cs320_mts.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cs320_mts.service.UserService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestUserService
{
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    /**
     * The default DB mode is "create"
     * This test creates 2 user and 2 account for each user.
     * This method should be run in order to initialize the DB and work with it for testing purposes.
     */
    @Test
    public void testCreateUser()
    {

        // Creation of first User
        User user = new User("Kerem","Ersan",12345,"07-04-2000","35007269396","kerem.ersan@ozu.edu.tr","5057656825");

        // Creation of first User's first account.
        Account account = new Account(300,user);
        user.getAccounts().add(account);
        account.setUser(user);

        // Creation of first User's second account.
        Account account2 = new Account(200,user);
        user.getAccounts().add(account2);
        account.setUser(user);

        // saves first User information to the DB
        userService.save(user);

        // Creation of second User
        User user2 = new User("Zuhal","Tokgözoğlu",973100,"05-06-1998","24107854293","zuhaltokgoz@gmail.com.tr","5511768127");

        // Creation of second User's first account
        Account account3 = new Account(1575,user2);
        user2.getAccounts().add(account3);
        account.setUser(user2);

        // Creation of second User's second account
        Account account4 = new Account(1870,user2);
        user2.getAccounts().add(account4);
        account4.setUser(user2);

        // saves second User information to the DB
        userService.save(user2);


    }
    @Test
    public void deleteAllRows()
    {
        userService.deleteAll();
    }

    /**
     * DB mode is "update"
     * This test creates a transaction object. And tries to do money transfer.
     * This method should be run as a second test. Because we need initial rows on DB.
     */
    @Test
    public void testCreateTransaction()
    {
        // creates transaction object.
        Transaction transaction = new Transaction(30,151);

        // retrieves the sender account. In this test, it is X.
        Account senderAccount = accountService.getById(152);
        if(accountService.moneyTransfer(senderAccount.getAccountId(),transaction))
        {
            System.out.println("Money Transfer has been made successfully");

        }else{
            System.out.println("Money Transfer is failed.");
        }



    }
}
