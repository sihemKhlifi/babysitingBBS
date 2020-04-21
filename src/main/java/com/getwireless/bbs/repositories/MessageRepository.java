package com.getwireless.bbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getwireless.bbs.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
