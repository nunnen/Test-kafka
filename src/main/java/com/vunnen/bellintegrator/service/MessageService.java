package com.vunnen.bellintegrator.service;

import com.vunnen.bellintegrator.dto.MessageIn;
import com.vunnen.bellintegrator.dto.MessageTo;
import com.vunnen.bellintegrator.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageProducer producer;

    public String getMessage(MessageIn messageIn) {
        return String.valueOf(messageIn.getMsg_id());
    }

    public MessageTo getMessageAndMap(MessageIn messageIn) {
        return MessageTo.builder()
                .msg_id(messageIn.getMsg_id())
                .timestamp(Instant.now().getEpochSecond())
                .method("POST")
                .uri("/post-message")
                .build();
    }

    public void sendMessage(String message) {
        producer.sendMessage(message);
    }



}
