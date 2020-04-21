package com.getwireless.bbs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dateMessage;
	private String objet;
	@ManyToOne
	private Candidat candidat;
	@ManyToOne
	private Annonce annonce;
	
	

}
