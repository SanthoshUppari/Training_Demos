package com.usk.kafkademo.kafkasender;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import com.usk.kafkademo.domain.User;
import com.usk.kafkademo.serializer.KafkaJsonSerializer;

@Service
public class UserObjProducer {

	@SuppressWarnings(value = { "rawtypes", "unchecked", "resource" })
	public void send(User user) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		Producer<String, User> kafkaProducer = new KafkaProducer<>(props, new StringSerializer(),
				new KafkaJsonSerializer());
		// Send a message
		kafkaProducer.send(new ProducerRecord<String, User>("usk_test", user));
	}

}
