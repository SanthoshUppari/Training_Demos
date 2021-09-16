package com.usk.kafkademo.kafkareader;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.usk.kafkademo.domain.User;

@Service
public class UserObjConsumer {

	@KafkaListener(topics = "usk_test")
	public void consume() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("value.deserializer", "com.usk.kafkademo.Deserializer.KafkaJsonDeserializer");

		KafkaConsumer<String, User> consumer = new KafkaConsumer<>(props);
		// Subscribe to the topic
		consumer.subscribe(Collections.singletonList("usk_test"));

		while (true) {
			ConsumerRecords<String, User> messages = consumer.poll(100);
			for (ConsumerRecord<String, User> message : messages) {
				System.out.println("Message received " + message.value().toString());
			}
		}
	}
}
