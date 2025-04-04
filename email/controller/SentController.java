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

import com.remit.email.model.Sent;
import com.remit.email.service.SentService;

/**
 * SentController
 */
@RestController
@CrossOrigin
public class SentController {
	@Autowired
	SentService service;
	
	/**
	 * 
	 * @return List<Sent>
	 */
	@GetMapping("/sent")
	public ResponseEntity<List<Sent>> getSent() {
		return ResponseEntity.ok(service.getSent());

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/sent/{id}")
	public  ResponseEntity<Sent> getSentById(@PathVariable int id) {
		return ResponseEntity.ok(service.getSentById(id));
	}
	
	/**
	 * 
	 * @param SentData
	 */
	@PostMapping("/sent")
	public ResponseEntity<?>  addSent(@RequestBody Sent SentData) {
		service.addSent(SentData);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}

	/**
	 * 
	 * @param SentData
	 */
	@PutMapping("/sent")
	public ResponseEntity<?>  updateSent(@RequestBody Sent SentData) {
		service.updateSent(SentData);
		return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();

	}

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/sent/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();

	}
}
