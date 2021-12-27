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
    public User save(User user) throws Exception {
        if(!isSixDigit(user.getPassword()))
            throw new Exception("Password length must be 6");
        if(!String.valueOf(user.getPassword()).matches("[0-9]+"))
            throw new Exception("Password must be only digits");

        if (user.getName().length() > 100 || user.getName().length() < 2)
            throw new Exception("Name must be between 2 and 100 characters");

        for(int i = 0 ; i < user.getName().length(); i++){
            if (!(user.getName().charAt(i) >= 'A' && user.getName().charAt(i) <= 'z'))
                throw new Exception("Name only includes letters");
        }
        if (user.getSurname().length() > 100 || user.getSurname().length() < 2)
            throw new Exception("Surname must be between 2 and 100 characters");

        for(int i = 0 ; i < user.getSurname().length(); i++){
            if (!(user.getSurname().charAt(i) >= 'A' && user.getSurname().charAt(i) <= 'z'))
                throw new Exception("Surname only includes letters");
        }
        if(user.getDateofBirth().length() != 10) {
            throw new Exception("It is not valid date of birth should be in form 30-12-2021");
        }
        if(user.getDateofBirth().charAt(2) != '-' || user.getDateofBirth().charAt(5) != '-'){
            throw new Exception("It is not valid date of birth should be in form 30-12-2021");
        }
        for(int i = 0 ; i < 2 ; i++ ){
            if(!(user.getDateofBirth().charAt(i) >= '0' && user.getDateofBirth().charAt(i) <= '9'))
                throw new Exception("Day is not in valid form");
        }
        for(int i = 3 ; i < 5 ; i++){
            if(!(user.getDateofBirth().charAt(i) >= '0' && user.getDateofBirth().charAt(i) <= '9'))
                throw new Exception("Month is not in valid form");
        }
        for(int i = 6 ; i < 10 ; i++){
            if(!(user.getDateofBirth().charAt(i) >= '0' && user.getDateofBirth().charAt(i) <= '9'))
                throw new Exception("Year is not in valid form");
        }

        int day   = Integer.parseInt(user.getDateofBirth().substring(0,2));
        int month   = Integer.parseInt(user.getDateofBirth().substring(3,5));
        int year    = Integer.parseInt(user.getDateofBirth().substring(6,10));

        if(year > 2004 || year < 1900)
            throw new Exception("Not valid year");
        if(month > 12 || 1 > month)
            throw new Exception("Not valid month");
        if(day > 31 || 1 > day)
            throw new Exception("Not valid day");

        if(user.getIdentificationNumber().length() != 11)
            throw new Exception("Identification number must be 11 digit number");
        for(int i = 0 ; i < user.getIdentificationNumber().length(); i++){
            if (!(user.getIdentificationNumber().charAt(i) >= '0' && user.getIdentificationNumber().charAt(i) <= '9'))
                throw new Exception("Identification number only includes digits");
        }

        if(!user.getEmail().contains("@"))
            throw new Exception("Email needs '@' character");

        if(user.getPhoneNumber().length() != 10)
            throw new Exception("Phone number must be 10 digits ");

        for(int i = 0 ; i < user.getPhoneNumber().length() ; i++){
            if(!(user.getPhoneNumber().charAt(i) >= '0' && user.getPhoneNumber().charAt(i) <= '9'))
                throw new Exception("Phone number only includes digits");
        }

        if(userRepository.getIdentificationNumberList().contains(user.getIdentificationNumber())) {
            throw new Exception("This user has already registered.");
        } else if(userRepository.getPhoneNumberList().contains(user.getPhoneNumber())) {
            throw new Exception("This phone number has already been used.");
        } else if(userRepository.getEmailList().contains(user.getEmail())) {
            throw new Exception("This email has already been used.");
        } else {
            return userRepository.save(user);
        }
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
	public void changePassword(int userId, int oldPassword, int newPassword) throws Exception {
        if(Integer.toString(oldPassword).length() != 6)
            throw new Exception("Old Password must be 6 digit number");
        if(Integer.toString(newPassword).length() != 6)
            throw new Exception("New Password must be 6 digit number");
        if(userRepository.getById(userId).getPassword()==oldPassword){
            if(userRepository.getById(userId).getPassword()!=newPassword && newPassword!=oldPassword){
                userRepository.changePassword(userId, oldPassword, newPassword);
            }
            else{
                throw new Exception("New password cannot be the same as old password");
            }
        }
        else{
            throw new Exception("The old password is written incorrectly.");
        }
	}

    @Override
    public List<String> getIdentificationNumberList() {
        return userRepository.getIdentificationNumberList();
    }

    @Override
    public List<String> getPhoneNumberList() {
        return userRepository.getPhoneNumberList();
    }

    @Override
    public List<String> getEmailList() {
        return userRepository.getEmailList();
    }

    @Override
    public int getPassword(int userId) {
        return userRepository.getPassword(userId);
    }

    private boolean isSixDigit(int password)
    {

        int count = 0;
        while(password > 0) {
            password /= 10;
            count++;
        }
        return count == 6;
    }

}
