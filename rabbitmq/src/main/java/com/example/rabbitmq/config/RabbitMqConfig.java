package com.example.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
//import com.rabbitmq.client.AMQP.Queue;

@Configuration
public class RabbitMqConfig {

	//@Value("${javainuse.rabbitmq.queue}")
	@Value(value = "")
	String queueName;

	@Value(value = "")
	String exchange;

	@Value(value = "")
	 private String routingKey;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

	@Bean
	public MessageConverter JsonMsgConverter() {
		return new Jackson2JsonMessageConverter();
	}


	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionfactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionfactory);
		rabbitTemplate.setMessageConverter(JsonMsgConverter());
		return rabbitTemplate;

	}

}
