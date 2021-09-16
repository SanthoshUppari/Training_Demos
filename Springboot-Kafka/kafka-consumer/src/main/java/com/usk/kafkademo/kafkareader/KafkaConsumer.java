package com.usk.kafkademo.kafkareader;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "usk_test")
    public void consume(String message) throws IOException {
		System.out.println("Message ====>> "+message);
    }

}
