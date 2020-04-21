package com.getwireless.bbs.sevices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.getwireless.bbs.entities.Utilisateur;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.model.PasswordDto;
import com.getwireless.bbs.repositories.UtilisateurRepository;
import com.getwireless.bbs.services.UtilisateurService;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public MessageResponse changePassword(PasswordDto pwDto) {
		Utilisateur user=utilisateurRepository.findById(pwDto.getId()).orElse(null);
		 if(user==null) {
			 
		  return new MessageResponse(false,"utilisateur intouvable");
			 
		 }
		 
		 boolean valid=passwordEncoder.matches(pwDto.getOldPassword(),user.getPassword());
		 if(!valid) {
			 return new MessageResponse(false, "Ancien mot de passe incorrect");
		 }
		 
		 String cryptedPassword=passwordEncoder.encode(pwDto.getNewPassword());
		 user.setPassword(cryptedPassword);
		 utilisateurRepository.save(user);

		return new MessageResponse(true,"opération effectuée avec succés");
	}

	@Override
	public MessageResponse activate(Integer id) {
		Utilisateur user=utilisateurRepository.findById(id).orElse(null);
		 if(user==null) {
			 
		  return new MessageResponse(false,"utilisateur intouvable");
			 
		 }
		 
		 user.setEnabled(!user.isEnabled());
		 utilisateurRepository.save(user);
		
		return new MessageResponse(true,"opération effectuée avec succés") ;
	}

}
