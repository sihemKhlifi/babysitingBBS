package com.getwireless.bbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getwireless.bbs.entities.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {

}
