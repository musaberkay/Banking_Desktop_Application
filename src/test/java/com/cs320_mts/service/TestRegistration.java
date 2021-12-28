package com.cs320_mts.service;


import com.cs320_mts.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestRegistration
{

    @Autowired
    UserService userService;

    /**
       It corresponds SRS-MTS-001.1
     */
    @Test
    public void createNewUser() throws Exception
    {
        User user = new User("Lebron","James",112255,"05-06-1982",
                "24106963586","lebron.james@ozu.edu.tr","5511094569");
        try
        {
            System.out.println("User is registered successfully");
            userService.save(user);
        }catch(Exception e)
        {
            System.out.println("Registration is failed");
        }
    }

    /**
     It corresponds SRS-MTS-001.2
     */
    @Test
    public void testSameID()
    {
        User user = new User("Lebron","James",112255,"05-06-1982",
                "24106963586","lebron.james@ozu.edu.tr","5511906985");
        try
        {
            userService.save(user);
            assertTrue(false);
        }catch(Exception e)
        {
            System.out.println("An account is already registered with this identification number");
            assertTrue(true);
        }
    }

    /**
     It corresponds SRS-MTS-001.3
     */

    @Test
    public void testUnder18age()
    {
        User user = new User("Lebron","James",112255,"05-06-2005",
                "24329763586","lebron.james@ozu.edu.tr","5511906985");

        try
        {
            userService.save(user);
            assertTrue(false);
        }catch(Exception e)
        {
            System.out.println("You are under 18");
            assertTrue(true);
        }
    }

    /**
     It corresponds SRS-MTS-001.4
     */

    @Test
    public void testEmptyBlanks()
    {
        User user = new User();
        user.setName("Melih");
        user.setSurname("Naneci");

        try{
            userService.save(user);
            assertTrue(false);
        }catch(Exception e)
        {
            System.out.println("Fill all the necessary spaces");
            assertTrue(true);
        }

    }


}
