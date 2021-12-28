package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

@SpringBootTest
public class TestMoneyTransferInside {
    private final static String SENDER_NUMBER = "35007269396";


    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;


    /**
     It corresponds SRS-MTS-006.1
     */
    @Test @Transactional
    public void testSendInside(){
        Account account1 = userService.getByIdentificationNumber(SENDER_NUMBER).getAccounts().get(0);
        Account account2 = userService.getByIdentificationNumber(SENDER_NUMBER).getAccounts().get(1);
        Transaction transaction = new Transaction(50,
                account2.getAccountId());
        try{
            accountService.moneyTransfer(account1.getAccountId(),transaction);
            System.out.println("Money transfer between user’s accounts is performed successfully.");
            assertTrue(true);
        }
        catch(Exception es){
            assertTrue(false);
        }


    }

    /**
     It corresponds SRS-MTS-006.2
     */
    @Test @Transactional
    public void testInsufficientBalance(){
        Account account1 = userService.getByIdentificationNumber(SENDER_NUMBER).getAccounts().get(0);
        Account account2 = userService.getByIdentificationNumber(SENDER_NUMBER).getAccounts().get(1);
        Transaction transaction = new Transaction(500,
                account2.getAccountId());
        try{
            accountService.moneyTransfer(account1.getAccountId(),transaction);
            System.out.println("Money transfer between user’s accounts ARE PERFORMED WHICH WE DONT WANT");
            assertTrue(false);
        }
        catch(Exception es){
            System.out.println("Money transfer between user’s accounts is not performed.");
            assertTrue(true);
        }
    }
}
