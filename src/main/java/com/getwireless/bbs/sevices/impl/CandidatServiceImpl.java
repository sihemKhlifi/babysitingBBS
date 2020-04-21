package com.getwireless.bbs.sevices.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.getwireless.bbs.entities.Candidat;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.repositories.CandidatRepository;
import com.getwireless.bbs.repositories.UtilisateurRepository;
import com.getwireless.bbs.services.CandidatService;


@Service
public  class CandidatServiceImpl implements CandidatService {
	
	
	@Autowired
	private CandidatRepository candidatRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public MessageResponse register(Candidat candidat) {
		boolean exist =utilisateurRepository.existsByEmail(candidat.getEmail());
		if(exist) {
			return new MessageResponse(false , "email exist déja");
			
		}
		
		exist=utilisateurRepository.existsByLogin(candidat.getLogin());
		if(exist) {
			return new MessageResponse(false,"login exist déja");
		}
		
		String cryptedPassword=passwordEncoder.encode(candidat.getPassword());
		candidat.setPassword(cryptedPassword);
		utilisateurRepository.save(candidat);
		return new MessageResponse(true,"opération effectutée avec succés");
	}

	@Override
	public MessageResponse update(Candidat candidat) {
		
		boolean exist =utilisateurRepository.existsByEmailAndId(candidat.getEmail(),candidat.getId());
		if(!exist) {
			exist=utilisateurRepository.existsByEmail(candidat.getEmail());
			if(exist) {
			return new MessageResponse(false , "email exist déja");
			
		}
		
		
		
		
		exist=utilisateurRepository.existsByLoginAndId(candidat.getLogin(),candidat.getId());
		if(!exist) {
			exist=utilisateurRepository.existsByLogin(candidat.getLogin());
		}
		if (exist) {
			return new MessageResponse(false,"login exist déja");
		}
		
		candidatRepository.save(candidat);
		}
		
		return new MessageResponse(true,"opération effectuée avec succés ");
		}
	

	@Override
	public List<Candidat> findAll() {
		// TODO Auto-generated method stub
		return candidatRepository.findAll();
	}

	@Override
	public Candidat findById(Integer id) {
		// TODO Auto-generated method stub
		return candidatRepository.findById(id).orElse(null);
	}

	

}
