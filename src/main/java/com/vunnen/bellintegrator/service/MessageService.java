package com.vunnen.bellintegrator.service;

import com.vunnen.bellintegrator.dto.MessageDTO;
import com.vunnen.bellintegrator.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageProducer producer;

    public String getMessage(MessageDTO messageDTO) {
        long msgId = messageDTO.getMsg_id();
        String word = "Message_" + msgId;
        System.out.println(word);
        return word;
    }

    public void sendMessage(String message) {
        producer.sendMessage(message);
    }



}
