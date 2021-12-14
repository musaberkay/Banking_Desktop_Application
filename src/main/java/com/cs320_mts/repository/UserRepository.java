package com.cs320_mts.repository;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>
{

}
