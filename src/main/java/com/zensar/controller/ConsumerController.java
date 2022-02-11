package com.zensar.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.Unmarshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.GetResponse;
import com.zensar.component.ConsumerComponent;
import com.zensar.config.ConsumerConfig;
import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerMessageDTO;
import com.zensar.service.MessageConsumerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rabbitmq.client.AMQP.Channel;
import com.rabbitmq.client.AMQP.Connection;

@RequestMapping("macy/consumer")
@RestController
public class ConsumerController {

	@Autowired
	MessageConsumerService service;

	@Autowired
	RabbitAdmin rabbitAdmin;

	@Autowired
	ConsumerComponent consumerComponent;

	@GetMapping(value = "/order", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_PROBLEM_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_PROBLEM_XML_VALUE })
	public ResponseEntity<String> consumeMessage(@RequestHeader("Authorization") String token) throws IOException, TimeoutException {

		com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();

		connectionFactory.setHost("localhost");

		try (com.rabbitmq.client.Connection connection = connectionFactory.newConnection();
				com.rabbitmq.client.Channel channel = connection.createChannel();) {

			channel.queueDeclare(ConsumerConfig.QUEUE_NAME, true, false, false, null);

			Properties properties = rabbitAdmin.getQueueProperties(ConsumerConfig.QUEUE_NAME);
			int reqCount = (Integer) properties.get(RabbitAdmin.QUEUE_MESSAGE_COUNT);

			// pull one message and ack manually and exit

			for (int i = 0; i < reqCount; i++) {
				GetResponse resp = channel.basicGet(ConsumerConfig.QUEUE_NAME, false);
				if (resp != null) {

					String message = new String(resp.getBody(), "UTF-8");

					System.out.println(" [x] Received '" + message + "'");

					ObjectMapper mapper = new ObjectMapper();

					ProducerMessageDTO dto = mapper.readValue(message, ProducerMessageDTO.class);

					service.consumeJsonOrder(token, dto);

					channel.basicAck(resp.getEnvelope().getDeliveryTag(), false);
				}
			}
			System.out.println();

		}
		
		return new ResponseEntity<String>("Successfully Consumed",HttpStatus.OK);

	}

	@GetMapping(value = "/orderxml", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public <T> ResponseEntity<String> consumeXMLMessage(@RequestHeader("Authorization") String token)
			throws IOException, TimeoutException, JAXBException {

		
		
		
		
		com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();

		connectionFactory.setHost("localhost");

		try (com.rabbitmq.client.Connection connection = connectionFactory.newConnection();
				com.rabbitmq.client.Channel channel = connection.createChannel();) {

			channel.queueDeclare(ConsumerConfig.QUEUE_NAME_XML, true, false, false, null);

			Properties properties = rabbitAdmin.getQueueProperties(ConsumerConfig.QUEUE_NAME_XML);
			int reqCount = (Integer) properties.get(RabbitAdmin.QUEUE_MESSAGE_COUNT);

			// pull one message and ack manually and exit

			for (int i = 0; i < reqCount; i++) {
				GetResponse resp = channel.basicGet(ConsumerConfig.QUEUE_NAME_XML, false);
				if (resp != null) {

					String message = new String(resp.getBody(), "UTF-8");
					System.out.println(" [x] Received '" + message + "'");

					XmlMapper xmlMapper = new XmlMapper();

					FulfillmentOrder order = xmlMapper.readValue(message, FulfillmentOrder.class);
					order.setTotalPurchaseAmount(order.getOrderTotals().getTotalPurchaseAmount());
					order.setSeparatorOrderTotals0(order.getOrderTotals().getSeparatorOrderTotals0());
					System.out.println(" [x] Received1 '" + message + "'");

					service.consumeXMLOrder(token, order);

					channel.basicAck(resp.getEnvelope().getDeliveryTag(), false);

				}
			}
			
			return new ResponseEntity<String>("Successfully Consumed",HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<String>("Error Occured!",HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	
	
	

//	@RabbitListener(queues = ConsumerConfig.QUEUE_NAME)
//	public void listener(OrderStatus dto) {		
//		if(dto!=null)
//		System.out.println("Message Consumed :------------ "+"\n"+dto.getProducerMessageDTO());
//}

}
