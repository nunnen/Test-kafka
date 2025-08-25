package com.vunnen.bellintegrator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectMapper objectMapper;

    public MessageTo getMessage(MessageIn messageIn) {
        return MessageTo.builder()
                .msg_id(String.valueOf(messageIn.getMsg_id()))
                .timestamp(String.valueOf(Instant.now().getEpochSecond()))
                .method("POST")
                .uri("/post-message")
                .build();
    }

    public void sendMessage(MessageTo messageTo) {
        String message = convertMessageToJson(messageTo);
        producer.sendMessage(message);
    }

    private String convertMessageToJson(MessageTo messageTo) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(messageTo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }


}
