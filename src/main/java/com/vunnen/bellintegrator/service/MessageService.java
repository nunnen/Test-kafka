package com.vunnen.bellintegrator.service;

import com.vunnen.bellintegrator.dto.MessageIn;
import com.vunnen.bellintegrator.dto.MessageTo;
import com.vunnen.bellintegrator.model.Message;
import com.vunnen.bellintegrator.model.MessageMapper;
import com.vunnen.bellintegrator.kafka.MessageProducer;
import com.vunnen.bellintegrator.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {
    private final MessageRepository repository;
    private final MessageProducer producer;
    private final MessageMapper mapper;

    public MessageTo getMessageTo(MessageIn messageIn) {
        log.info("Mapping message-{} from messageIn to messageTo", messageIn.getMsg_id());
        return MessageTo.builder()
                .msg_id(String.valueOf(messageIn.getMsg_id()))
                .timestamp(String.valueOf(Instant.now().toEpochMilli()))
                .method("POST")
                .uri("/post-message")
                .build();
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "messages")
    public void listen(MessageTo messageTo) {
        Message message = mapper.mapTo(messageTo);
        log.info("Listening message-{}", message);
        repository.save(message);
        log.info("Saving message-{}", message.getMsgId());
    }

    public void sendMessage(MessageTo messageTo) {
        log.info("Sending message-{} to kafka", messageTo.getMsg_id());
        producer.sendMessage(messageTo);
    }


}
