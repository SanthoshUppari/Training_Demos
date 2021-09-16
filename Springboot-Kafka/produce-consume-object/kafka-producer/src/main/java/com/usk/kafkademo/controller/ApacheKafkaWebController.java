package com.usk.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.kafkademo.domain.User;
import com.usk.kafkademo.kafkasender.KafkaSender;
import com.usk.kafkademo.kafkasender.UserObjProducer;

@RestController
@RequestMapping(value = "/usk-kafka")
public class ApacheKafkaWebController {

	@Autowired
	KafkaSender kafkaSender;
	
	@Autowired
	UserObjProducer userObjProducer; 

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic usk_test Successfully";
	}
	
	@GetMapping(value = "/objproducer")
	public String ObjProducer(@RequestParam("message") String message) {
		User user = new User(message, 16);
		
		userObjProducer.send(user);

		return "User Obj sent to the Kafka Topic usk_test Successfully";
	}
}
