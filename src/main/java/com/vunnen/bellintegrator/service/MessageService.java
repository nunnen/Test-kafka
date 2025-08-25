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

    public MessageTo getMessage(MessageIn messageIn) {
        return MessageTo.builder()
                .msg_id(String.valueOf(messageIn.getMsg_id()))
                .timestamp(String.valueOf(Instant.now().toEpochMilli()))
                .method("POST")
                .uri("/post-message")
                .build();
    }

    public void sendMessage(MessageTo messageTo) {
        producer.sendMessage(messageTo);
    }


}
