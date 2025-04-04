package com.remit.email.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.remit.email.model.Inbox;
import com.remit.email.mapper.InboxMapper;
import com.remit.email.repository.InboxRepo;
import com.remit.email.service.InboxService;

/**
 * InboxService
 */

@Service
public class InboxServiceImpl implements InboxService {
	@Autowired
	InboxRepo repo;
	InboxMapper inboxMapper = InboxMapper.INSTANCE;

	/**
	 * 
	 * @return List<Inbox>
	 */
	@Override
	public List<Inbox> getInbox() {
		
		return repo.findAll().stream().map(entityInbox -> inboxMapper.toDTO(entityInbox)).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Inbox getInboxById(int id) {
		return  inboxMapper.toDTO(repo.findById(id).get());
	}
	
	/**
	 * 
	 * @param inboxData
	 */
	@Override
	public void addInbox(Inbox inboxData) {
		repo.save(inboxMapper.toEntity(inboxData));
	}

	/**
	 * 
	 * @param inboxData
	 */
	@Override
	public void updateInbox(Inbox inboxData) {
		repo.save(inboxMapper.toEntity(inboxData));

	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public void deleteById(int id) {
		repo.deleteById(id);

	}

}
