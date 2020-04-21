package com.getwireless.bbs.services;

import com.getwireless.bbs.entities.Utilisateur;
import com.getwireless.bbs.model.MessageResponse;
import com.getwireless.bbs.model.PasswordDto;

public interface UtilisateurService {
	
	public MessageResponse changePassword(PasswordDto pwdDto);
	public MessageResponse activate(Integer id);
}
