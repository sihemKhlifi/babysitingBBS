package com.getwireless.bbs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String photo;
	private String email;
	private boolean enabled;
	
	@OneToOne(mappedBy = "utilisateur")
	private Adresse adresse;

}
