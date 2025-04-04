package com.remit.email.service;

import java.util.List;

import com.remit.email.model.Sent;
/**
 * SentService
 */
public interface SentService {
	
	public List<Sent> getSent();
	public Sent getSentById(int id);
	public void addSent(Sent SentData);
	public void updateSent(Sent SentData);
	public void deleteById(int id);
}
