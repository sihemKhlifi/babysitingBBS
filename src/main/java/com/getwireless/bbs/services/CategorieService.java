package com.getwireless.bbs.services;

import java.util.List;

import com.getwireless.bbs.entities.Categorie;
import com.getwireless.bbs.model.MessageResponse;

public interface CategorieService {

	public MessageResponse save(Categorie categorie);
	public MessageResponse update(Categorie categorie);
	public MessageResponse delete(Integer id);
	public List<Categorie> findAll();
	public Categorie findById(Integer id);
}
