package com.cs320_mts.service;

import com.cs320_mts.model.Account;

import java.util.List;

public interface AccountService {
    public Account save(Account account);
    public List<Account> getAll();
    public Account getById(int id);
    public void deleteById(int id);
}
