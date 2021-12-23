package com.cs320_mts.repository;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    public User getByIdentificationNumber(String id_num);
}
