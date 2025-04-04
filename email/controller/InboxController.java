package com.remit.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remit.email.model.Inbox;
import com.remit.email.service.InboxService;

/**
 * InboxController
 */
@RestController
@CrossOrigin
public class InboxController {
	
	@Autowired
	InboxService service;
	
	/**
	 * 
	 * @return List<Inbox>
	 */
	@GetMapping("inbox")
	public ResponseEntity<List<Inbox>> getInbox() {
		return ResponseEntity.ok(service.getInbox()) ;

	}

	/**
	 * 
	 * @param id
	 * @return Inbox
	 */
	@GetMapping("inbox/{id}")
	public ResponseEntity<Inbox> getinboxById(@PathVariable int id) {
		return ResponseEntity.ok(service.getInboxById(id));
	}

	/**
	 * 
	 * @param inboxData
	 */
	@PostMapping("inbox")
	public ResponseEntity<?> addinbox(@RequestBody Inbox inboxData) {
		service.addInbox(inboxData);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}

	/**
	 * 
	 * @param inboxData
	 */
	@PutMapping("inbox")
	public ResponseEntity<?> updateinbox(@RequestBody Inbox inboxData) {
		service.updateInbox(inboxData);
		return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
	}
	
	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("inbox/{id}")
	public  ResponseEntity<?> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
