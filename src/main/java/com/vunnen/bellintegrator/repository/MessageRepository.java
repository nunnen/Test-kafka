package com.vunnen.bellintegrator.repository;

import com.vunnen.bellintegrator.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
