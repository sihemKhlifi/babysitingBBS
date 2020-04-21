package com.getwireless.bbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getwireless.bbs.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

	boolean existsByNom(String nom);

	boolean existsByNomAndId(String nom, Integer id);

	boolean existsByParent(Categorie cat);

}
