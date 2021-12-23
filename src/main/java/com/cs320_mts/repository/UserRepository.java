package com.cs320_mts.repository;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    public static final String CHANGE_PASSWORD = "UPDATE User AS u SET u.password = :newPassword WHERE u.userId = :userId AND u.password = :oldPassword";
    
    public static final String FIND_USER_ID_NUMBERS = "SELECT u.identificationNumber FROM User AS u";
    
    public static final String FIND_USER_PHONE_NUMBERS = "SELECT u.phoneNumber FROM User AS u";
    
    public static final String FIND_USER_EMAILS = "SELECT u.email FROM User AS u";
    
    @Modifying
    @Query(value = CHANGE_PASSWORD)
    public void changePassword(int userId, int oldPassword, int newPassword);
    
    @Query(value = FIND_USER_ID_NUMBERS)
    public List<String> getIdentificationNumberList();
    
    @Query(value = FIND_USER_PHONE_NUMBERS)
    public List<String> getPhoneNumberList();
    
    @Query(value = FIND_USER_EMAILS)
    public List<String> getEmailList();
    
    public User getByIdentificationNumber(String id_num);
}
