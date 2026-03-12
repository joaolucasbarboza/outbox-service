package com.joaobarboza.outbox_service.core.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload) {
        try {
            log.info("Sending event, topic:{}, payload:{}", topic, payload);
            kafkaTemplate.send(topic, payload);
        } catch (Exception e) {
            log.error("Error trying to send event: topic:{}, payload:{}", topic, payload, e);
        }
    }
}
