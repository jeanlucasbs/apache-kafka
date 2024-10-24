package com.jeanlucas.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message).whenComplete((result, e) -> {
            if (e != null) {
                log.error("Messagem não enviada: {}", e.getMessage());
            } else {
                log.info("Messagem enviada: {}", result.getRecordMetadata().partition());
            }
        });
    }
}
