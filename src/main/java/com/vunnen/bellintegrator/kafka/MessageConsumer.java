package com.vunnen.bellintegrator.kafka;

import com.vunnen.bellintegrator.dto.MessageTo;
import com.vunnen.bellintegrator.model.Message;
import com.vunnen.bellintegrator.model.MessageMapper;
import com.vunnen.bellintegrator.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageConsumer {
    private final MessageRepository repository;
    private final MessageMapper mapper;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.groupId}")
    public void listen(MessageTo messageTo) {
        Message message = mapper.mapTo(messageTo);
        log.info("Listening message-{}", message);
        repository.save(message);
        log.info("Saving message-{}", message.getMsgId());
    }
}
