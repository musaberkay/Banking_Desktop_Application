package com.cs320_mts.service;

import com.cs320_mts.model.Account;
import com.cs320_mts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService
{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public Account getById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        accountRepository.deleteById(id);
    }
}
