package com.cs320_mts.service;

import com.cs320_mts.model.User;

import java.util.List;


public interface UserService
{
    public User save(User user);
    public List<User> getAll();
    public User getById(int id);
    public void deleteById(int id);
}
