package com.getwireless.bbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.model.PasswordDto;
import com.getwireless.bbs.services.UtilisateurService;

@RestController
@CrossOrigin("*")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@PatchMapping
	public MessageResponse changePassword(@RequestBody PasswordDto passwordDto) {
		 return utilisateurService.changePassword(passwordDto);
	}
	
	
	
	
	@PatchMapping("/{id}")
	public MessageResponse activate(@PathVariable Integer id) {
	
    return utilisateurService.activate(id);
}
}
