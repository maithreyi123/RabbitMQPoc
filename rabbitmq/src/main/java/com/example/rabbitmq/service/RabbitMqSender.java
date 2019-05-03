package com.example.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.empdomain.EmpDomain;

@Service
public class RabbitMqSender {

	@Autowired
	public AmqpTemplate amqpTemp;

	@Value("")
	String exchange;

	@Value("")
	String routingKey;
    String KafkaTopic="java_inuse_topic";
    
    
	public void send(EmpDomain sendtopic) {
		amqpTemp.convertAndSend(exchange, routingKey, sendtopic);
		System.out.println("sent msg =" + sendtopic);

	}

}
