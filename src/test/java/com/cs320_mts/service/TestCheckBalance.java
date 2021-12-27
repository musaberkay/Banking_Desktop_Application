package com.cs320_mts.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestCheckBalance {
    private final static String ID_NUMBER = "35007269396";
    private final static double first_amount = 300;


    @Autowired
    UserService userService;

    /**
     It corresponds SRS-MTS-004
     */
    @Test
    @Transactional
    public void testCheckBalance(){
        try{
            if(userService.getByIdentificationNumber(ID_NUMBER).getAccounts().get(0).getBalance()==first_amount){
                assertTrue(true);
                System.out.println("Balance is succesfully showed.");
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
