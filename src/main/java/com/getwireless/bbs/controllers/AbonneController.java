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

import com.getwireless.bbs.entities.Abonne;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.services.AbonneService;

@RestController
@RequestMapping("/abonne")
@CrossOrigin("*")
public class AbonneController {
	
	
	@Autowired
	private AbonneService abonneService;

	@PostMapping
	public MessageResponse register(@RequestBody Abonne abonne) {
		return abonneService.register(abonne);
	}

	@PutMapping
	public MessageResponse update(@RequestBody Abonne abonne) {
		return abonneService.update(abonne);
	}

	
	
	
	
	@GetMapping
	public List<Abonne> findAll() {
		return abonneService.findAll();
	}
	
	@GetMapping("/{id}")
	public Abonne findById(@PathVariable Integer id) {
		return abonneService.findById(id);
	}
}
