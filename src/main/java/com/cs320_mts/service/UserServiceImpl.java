package com.cs320_mts.service;

import com.cs320_mts.model.User;
import com.cs320_mts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public User getByIdentificationNumber(String id_num){
        return userRepository.getByIdentificationNumber(id_num);
    }
    
    @Override
	@Transactional
	public void changePassword(int userId, int oldPassword, int newPassword) {
		userRepository.changePassword(userId, oldPassword, newPassword);
	}
}
