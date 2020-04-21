package com.getwireless.bbs.services;

import java.util.List;

import com.getwireless.bbs.entities.Abonne;
import com.getwireless.bbs.model.MessageResponse;

public interface AbonneService {

	public MessageResponse register(Abonne abonne);

	public MessageResponse update(Abonne abonne);

	public List<Abonne> findAll();

	public Abonne findById(Integer id);




}
