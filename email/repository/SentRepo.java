package com.remit.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remit.email.entity.Sent;

/**
 * SentRepo
 */
@Repository
public interface SentRepo extends JpaRepository<Sent,Integer> {

}
