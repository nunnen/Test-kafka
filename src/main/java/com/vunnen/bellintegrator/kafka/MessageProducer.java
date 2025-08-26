package com.vunnen.bellintegrator.kafka;

import com.vunnen.bellintegrator.dto.MessageTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {
    private final KafkaTemplate<String, MessageTo> kafkaTemplate;
    @Value("${kafka.topic.name}")
    private String topic;

    public void sendMessage(MessageTo messageTo) {
        log.info("Sending Message to topic: " + topic);
        kafkaTemplate.send(topic, messageTo);
    }
}
