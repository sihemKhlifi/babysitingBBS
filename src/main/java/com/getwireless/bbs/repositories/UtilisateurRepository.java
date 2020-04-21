package com.getwireless.bbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getwireless.bbs.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {



	boolean existsByLogin(String login);

	boolean existsByEmailAndId(String email, Integer id);

	boolean existsByEmail(String email);

	boolean existsByLoginAndById(String login, Integer id);


}
