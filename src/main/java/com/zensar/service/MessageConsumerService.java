package com.zensar.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerMessageDTO;

public interface MessageConsumerService {

	
	public ResponseEntity<String> consumeJsonOrder(String token,@RequestBody ProducerMessageDTO newOrder);
	
	public ResponseEntity<String> consumeXMLOrder(String token,@RequestBody FulfillmentOrder newOrder);
}
