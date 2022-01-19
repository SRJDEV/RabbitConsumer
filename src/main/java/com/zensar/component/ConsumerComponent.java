package com.zensar.component;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerMessageDTO;

@Component
public class ConsumerComponent {

	@Autowired
	@Qualifier("JSON_AMQP_TEMPLATE")
	AmqpTemplate jsonTemplate;

	@Autowired
	@Qualifier("XML_AMQP_TEMPLATE")
	AmqpTemplate xmlTemplate;

	@Autowired
	@Qualifier("JsonProducerQueue")
	Queue jsonProducerQueue;

	@Autowired
	@Qualifier("XMLProducerQueue")
	Queue xmlProducerQueue;



	
	
	
}
