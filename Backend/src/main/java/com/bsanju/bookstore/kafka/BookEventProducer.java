package com.bsanju.bookstore.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookEventProducer {

    private static final String TOPIC = "book-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
