package com.getwireless.bbs.services;

import java.util.List;

import com.getwireless.bbs.entities.Candidat;
import com.getwireless.bbs.model.MessageResponse;

public interface CandidatService {

	public MessageResponse register(Candidat candidat);

	public MessageResponse update(Candidat candidat);

	public List<Candidat> findAll();

	public Candidat findById(Integer id);

	
}
