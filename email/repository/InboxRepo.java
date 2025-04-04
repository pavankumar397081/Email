package com.remit.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remit.email.entity.Inbox;

/**
 * InboxRepo
 */
@Repository
public interface InboxRepo extends JpaRepository<Inbox,Integer>{

}
