package com.vunnen.bellintegrator.producer;

import com.vunnen.bellintegrator.dto.MessageTo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, MessageTo> kafkaTemplate;
    @Value("${kafka.topic.name}")
    private String topic;

    public void sendMessage(MessageTo messageTo) {
        kafkaTemplate.send(topic, messageTo);
    }
}
