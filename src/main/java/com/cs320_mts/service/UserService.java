package com.cs320_mts.service;

import com.cs320_mts.model.User;

import java.util.List;


public interface UserService
{
    public User save(User user) throws Exception;
    public List<User> getAll();
    public User getById(int id);
    public void deleteById(int id);
    public void deleteAll();
    public User getByIdentificationNumber(String id_num);
    public void changePassword(int userId, int oldPassword, int newPassword);
    public List<String> getIdentificationNumberList();
    public List<String> getPhoneNumberList();
    public List<String> getEmailList();
    public int getPassword(int userId);
}
