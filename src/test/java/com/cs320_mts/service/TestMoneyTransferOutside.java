package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

@SpringBootTest
public class TestMoneyTransferOutside {
    private final static String SENDER_NUMBER = "35007269396";
    private final static String RECEIVER_NUMBER = "24107854293";


    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;


    /**
     It corresponds SRS-MTS-007.1
     */
    @Test @Transactional
    public void testSendOutside(){
        Account account1 = userService.getByIdentificationNumber(SENDER_NUMBER).getAccounts().get(0);
        Account account2 = userService.getByIdentificationNumber(RECEIVER_NUMBER).getAccounts().get(0);
        Transaction transaction = new Transaction(50,
                account2.getAccountId());
        try{
            accountService.moneyTransfer(account1.getAccountId(),transaction);
            assertTrue(true);
        }
        catch(Exception es){
            assertTrue(false);
        }


    }

    /**
     It corresponds SRS-MTS-007.2
     */
    @Test @Transactional
    public void testNotExistAccount(){
        Account account1 = userService.getByIdentificationNumber(SENDER_NUMBER).getAccounts().get(0);
        int notExistId = -1;
        Transaction transaction = new Transaction(50,
                notExistId);
        try{
            accountService.moneyTransfer(account1.getAccountId(),transaction);
            assertTrue(true);
        }
        catch(Exception es){
            assertTrue(false);
        }
    }

    /**
     It corresponds SRS-MTS-007.3
     */
    @Test @Transactional
    public void testInsufficientBalance(){
        Account account1 = userService.getByIdentificationNumber(SENDER_NUMBER).getAccounts().get(0);
        Account account2 = userService.getByIdentificationNumber(RECEIVER_NUMBER).getAccounts().get(0);
        Transaction transaction = new Transaction(500,
                account2.getAccountId());
        try{
            accountService.moneyTransfer(account1.getAccountId(),transaction);
            assertTrue(true);
        }
        catch(Exception es){
            assertTrue(false);
        }


    }
}
