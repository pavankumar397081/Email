package com.remit.email.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remit.email.mapper.SentMapper;
import com.remit.email.model.Sent;
import com.remit.email.repository.SentRepo;
import com.remit.email.service.SentService;

/**
 * SentService
 */
@Service
public class SentServiceImpl implements SentService{
	@Autowired
	SentRepo repo;
	SentMapper sentMapper = SentMapper.INSTANCE;
	
	/**
	 * 
	 * @return List<Sent> 
	 */
	@Override
	public List<Sent> getSent() {
		return repo.findAll().stream().map(entitySent -> sentMapper.toDTO(entitySent)).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Sent getSentById(int id) {
		return  sentMapper.toDTO(repo.findById(id).get());
	}

	/**
	 * 
	 * @param SentData
	 */
	@Override
	public void addSent(Sent SentData) {
		repo.save(sentMapper.toEntity(SentData));

	}

	/**
	 * 
	 * @param SentData
	 */
	@Override
	public void updateSent(Sent SentData) {
		repo.save(sentMapper.toEntity(SentData));

	}
/**
 * 
 * @param id
 */@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
