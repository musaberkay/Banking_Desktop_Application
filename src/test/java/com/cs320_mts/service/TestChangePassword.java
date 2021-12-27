package com.cs320_mts.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestChangePassword {

    private final static String ID_NUMBER = "35007269396";
    private final static int OLD_PASSWORD = 123456;
    private final static int NEW_PASSWORD = 111111;
    private final static int WRONG_PASSWORD = 123457;

    @Autowired
    UserService userService;

    /**
     It corresponds SRS-MTS-003.1
     */
    @Test @Transactional
    public void testChangePassword(){
        try{
            int userId = userService.getByIdentificationNumber(ID_NUMBER).getUserId();
            userService.changePassword(userId, OLD_PASSWORD, NEW_PASSWORD);
            if(userService.getPassword(userId)==NEW_PASSWORD){
                System.out.println("Password is successfully changed");
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
     It corresponds SRS-MTS-003.2
     */
    @Test @Transactional
    public void testWrongOldPassword(){
        try{
            int userId = userService.getByIdentificationNumber(ID_NUMBER).getUserId();
            userService.changePassword(userId, WRONG_PASSWORD, NEW_PASSWORD);
            if(userService.getPassword(userId)==NEW_PASSWORD){
                assertTrue(true);
                System.out.println("Password is successfully changed");
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
     It corresponds SRS-MTS-003.3
     */
    @Test @Transactional
    public void testSameOldandNewPassword(){
        try{
            int userId = userService.getByIdentificationNumber(ID_NUMBER).getUserId();
            userService.changePassword(userId, OLD_PASSWORD, OLD_PASSWORD);
            if(userService.getPassword(userId)==NEW_PASSWORD){
                assertTrue(true);
                System.out.println("Password is successfully changed");
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
