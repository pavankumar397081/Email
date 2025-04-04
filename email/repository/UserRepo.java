package com.remit.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remit.email.entity.User;

/**
 * UserRepo
 */
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
