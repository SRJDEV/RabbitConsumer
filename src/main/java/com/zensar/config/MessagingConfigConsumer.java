package com.zensar.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class MessagingConfigConsumer {

	
	public static final String ROUTING_KEY = "macy_order_routing_key";

	public static final String TOPIC_EXCHANGE = "macy_order_exchange";

	public static final String QUEUE_NAME = "macy_order_queue";

	
	public static String QUEUE_NAME_XML = "macy_order_xml_queue";

	@Bean
	public Queue queueXML() {
		return new Queue(QUEUE_NAME_XML);
	}

	@Bean
	public TopicExchange exchangeXML() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	public Binding bindXML(Queue queue, TopicExchange exchange) {

		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	
	
	
	@Bean
	public MessageConverter converterXML() {
		return new Jackson2XmlMessageConverter();
	}
	




	@Bean
	public AmqpTemplate templateXML(ConnectionFactory connectionFactory) {
		
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converterXML());
		rabbitTemplate.setDefaultReceiveQueue(QUEUE_NAME_XML);
		
		return rabbitTemplate;

	}
	
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}

	@Bean
	public Binding bind(Queue queue, TopicExchange exchange) {

		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {

		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		rabbitTemplate.setDefaultReceiveQueue(QUEUE_NAME);
		return rabbitTemplate;

	}
	 @Bean
	    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
	        return new RabbitAdmin(connectionFactory);
	    }
}
