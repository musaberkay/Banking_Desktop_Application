package com.cs320_mts.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest
public class TestLogin
{
    private final static String ID_NUMBER = "35007269396";
    private final static int PASSWORD = 123456;
    private final static int WRONG_PASSWORD = 123457;
    private final static String WRONG_ID_NUMBER = "46118370407";


    @Autowired
    UserService userService;


    /**
     It corresponds SRS-MTS-002.1
     */
    @Test
    public void testLogin()
    {
        try
        {
            int userId =  userService.getByIdentificationNumber(ID_NUMBER).getUserId();

            if(userService.getPassword(userId)  == PASSWORD)
            {
                assertTrue(true);
                System.out.println("Login is successfully completed");
            } else
                assertTrue(false);

        }catch(Exception e)
        {
            assertTrue(false);
        }
    }

    /**
     It corresponds SRS-MTS-002.2
     */
    @Test
    public void testCorrectIdWrongPassword()
    {
        try
        {
            int userId =  userService.getByIdentificationNumber(ID_NUMBER).getUserId();

            if(userService.getPassword(userId)  != WRONG_PASSWORD)
            {
                assertTrue(true);
                System.out.println("the password corresponds is wrong");
            } else
                assertTrue(false);

        }catch(Exception e)
        {
            assertTrue(false);
        }
    }

    /**
     It corresponds SRS-MTS-002.3
     */
    @Test
    public void testIdNotFound()
    {
        try
        {
            int userId =  userService.getByIdentificationNumber(WRONG_ID_NUMBER).getUserId();
            assertTrue(false);
        }catch(Exception e)
        {
            assertTrue(true);
            System.out.println("There is no user with that id number.");
        }
    }

}

