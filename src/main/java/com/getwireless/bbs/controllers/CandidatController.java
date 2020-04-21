package com.getwireless.bbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.getwireless.bbs.entities.Candidat;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.services.CandidatService;

@RestController
@RequestMapping("/candidat")
@CrossOrigin("*")
public class CandidatController {
	@Autowired
	private CandidatService candidatService;

	@PostMapping
	public MessageResponse save(@RequestBody Candidat candidat) {
		return candidatService.register(candidat);
	}

	@PutMapping
	public MessageResponse update(@RequestBody Candidat candidat) {
		return candidatService.update(candidat);
	}

	

	
	
	
	@GetMapping
	public List<Candidat> findAll() {
		return candidatService.findAll();
	}
	
	@GetMapping("/{id}")
	public Candidat findById(@PathVariable Integer id) {
		return candidatService.findById(id);
	}
}
