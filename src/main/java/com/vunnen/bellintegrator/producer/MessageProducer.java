package com.vunnen.bellintegrator.producer;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "postedmessages";

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
    }
}
