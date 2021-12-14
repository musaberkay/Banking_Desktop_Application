package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAccountService
{
    @Autowired
    AccountService accountService;

    @Test
    public void testCreateAccount()
    {

    }
}
