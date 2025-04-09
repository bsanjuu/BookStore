package com.bsanju.bookstore.kafka;

import com.bsanju.bookstore.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookEventConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "book-events", groupId = "bookstore-group")
    public void listen(String message) {
        System.out.println("Received Kafka Event: " + message);


        if (message.contains("NEWBOOK")) {
            notificationService.sendEmail("New Book Added", message);
        } else if (message.contains("PURCHASE")) {
            notificationService.sendEmail(" Book Purchased", message);
        }
    }
}
