package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestCreateAccount {
    private final static String ID_NUMBER = "35007269396";

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;


    /**
     It corresponds SRS-MTS-005.1
     */
    @Test @Transactional
    public void testCreateAccount(){
        try{
            if(userService.getByIdentificationNumber(ID_NUMBER).getAccounts().size()<3){
                Account account = new Account();
                account.setUser(userService.getByIdentificationNumber(ID_NUMBER));
                account.setBalance(0);  // NOW DEFAULT, WILL BE DESIGNED
                userService.getByIdentificationNumber(ID_NUMBER).getAccounts().add(account);
                accountService.save(account);
                System.out.println("New account is successfully added");
                assertTrue(true);
            }
            else{
                assertTrue(false);
            }
        }
        catch(Exception e){
            assertTrue(false);
        }

    }

    /**
     It corresponds SRS-MTS-005.2
     */
    @Test @Transactional
    public void testLimitOutAccount(){
        Account account = new Account();
        account.setBalance(0);
        account.setUser(userService.getByIdentificationNumber(ID_NUMBER));
        userService.getByIdentificationNumber(ID_NUMBER).getAccounts().add(account);
        accountService.save(account);

        try{
            if(userService.getByIdentificationNumber(ID_NUMBER).getAccounts().size() == 3){

                userService.getByIdentificationNumber(ID_NUMBER).getAccounts().add(account);
                accountService.save(account);
                System.out.println("New account is successfully added");
                assertTrue(true);

            }
            else{
                assertTrue(false);
            }
        }
        catch(Exception e){
            assertTrue(false);
        }
    }
}
