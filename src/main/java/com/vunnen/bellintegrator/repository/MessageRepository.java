package com.vunnen.bellintegrator.repository;

import com.vunnen.bellintegrator.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
