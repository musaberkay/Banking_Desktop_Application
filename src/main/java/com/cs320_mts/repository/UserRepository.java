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
    
    @Modifying
    @Query(value = CHANGE_PASSWORD)
    public void changePassword(int userId, int oldPassword, int newPassword);
    
    public User getByIdentificationNumber(String id_num);
}
