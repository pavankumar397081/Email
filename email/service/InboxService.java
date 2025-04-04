package com.remit.email.service;

import java.util.List;

import com.remit.email.model.Inbox;

/**
 * InboxService
 */
public interface InboxService {

	public List<Inbox> getInbox();

	public Inbox getInboxById(int id);

	public void addInbox(Inbox inboxData);

	public void updateInbox(Inbox inboxData);

	public void deleteById(int id);
}
