package com.zensar.listener;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zensar.config.MessagingConfigConsumer;
import com.zensar.dto.OrderConsumerDTO;
import com.zensar.dto.OrderStatus;
import com.zensar.dto.ProducerMessageDTO;
import com.zensar.entity.ConsumerMessageEntity;
import com.zensar.repository.MessageRepositoryConsumer;


public class MessageListener {

	
	
//	@Autowired
//	MessageRepositoryConsumer repo;
//	
//	@Autowired
//	ModelMapper modelMapper;
//	
//	@RabbitListener(queues = MessagingConfigConsumer.QUEUE_NAME)
//	public void listener(OrderStatus dto) {
//		
//		System.out.println("Message Consumed :------------ "+"\n"+dto.getProducerMessageDTO());
//		
//		//add to db
//		
//		ConsumerMessageEntity entity = this.modelMapper.map(dto.getProducerMessageDTO(), ConsumerMessageEntity.class);
//		
//		entity =	repo.save(entity);
//		
//		
//		
//		ProducerMessageDTO pmDTO = this.modelMapper.map(entity, ProducerMessageDTO.class);
//		
//	}
	
	
}
