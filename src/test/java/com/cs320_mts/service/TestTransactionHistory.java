package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestTransactionHistory {
    private final static String ID_NUMBER = "35007269396";

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    /**
     It corresponds SRS-MTS-008
     */
    @Test
    @Transactional
    public void testTransaction(){
        Account account1 = userService.getByIdentificationNumber(ID_NUMBER).getAccounts().get(0);
        Account account2 = userService.getByIdentificationNumber(ID_NUMBER).getAccounts().get(1);
        Transaction transaction = new Transaction(50,
                account2.getAccountId());
        try{
            accountService.moneyTransfer(account1.getAccountId(),transaction);
            if(account1.getTransactions().size()>0){
                System.out.println("Transfer history is succesfully implemented.");
                assertTrue(true);
            }
            else{
                assertTrue(false);
            }
        }
        catch(Exception es){
            assertTrue(false);
        }
    }
}
