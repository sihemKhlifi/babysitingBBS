package com.getwireless.bbs.sevices.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getwireless.bbs.entities.Categorie;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.repositories.CategorieRepository;
import com.getwireless.bbs.services.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {
	@Autowired
	private CategorieRepository categorieRepository;

	@Override
	public MessageResponse save(Categorie categorie) {

		boolean exist = categorieRepository.existsByNom(categorie.getNom());
		if (exist) {
			return new MessageResponse(false, "Nom catégorie existe déja");
		}
		categorieRepository.save(categorie);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Categorie categorie) {
		boolean exist = categorieRepository.existsByNomAndId(categorie.getNom(), categorie.getId());
		if (!exist) {
			exist = categorieRepository.existsByNom(categorie.getNom());
			if (exist) {
				return new MessageResponse(false, "Nom catégorie existe déja");
			}
		}
		categorieRepository.save(categorie);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(Integer id) {
		Categorie cat = categorieRepository.findById(id).orElse(null);
		boolean exist = categorieRepository.existsByParent(cat);
		if (exist) {
			return new MessageResponse(false, "Catégorie affectée a un ou plusieurs sous catégoriescx");
		}
		categorieRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Categorie findById(Integer id) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(id).orElse(null);
	}
}
