package com.zensar.service;

import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.GetResponse;
import com.zensar.config.MessagingConfigConsumer;
import com.zensar.dto.BillingInfo;
import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerMessageDTO;
import com.zensar.entity.AddressEntity;
import com.zensar.entity.BillingInfoEntity;
import com.zensar.entity.ConsumerMessageEntity;
import com.zensar.entity.FulfilmentOrderEntity;
import com.zensar.entity.SourceEntity;
import com.zensar.repository.AddressRepo;
import com.zensar.repository.BillingInfoRepo;
import com.zensar.repository.MessageRepositoryConsumer;
import com.zensar.repository.SourceRepo;
import com.zensar.repository.XMLRepository;

@Service
public class MessageConsumerServiceImp implements MessageConsumerService {

	@Autowired
	MessageRepositoryConsumer repo;

	@Autowired
	XMLRepository repoXML;

	@Autowired
	SourceRepo sourceRepo;

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	BillingInfoRepo billingInfoRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<String> consumeNewOrder(String token, ProducerMessageDTO newOrder) {

		ConsumerMessageEntity entity = this.modelMapper.map(newOrder, ConsumerMessageEntity.class);

		entity = repo.save(entity);

		// ProducerMessageDTO pmDTO = this.modelMapper.map(entity,
		// ProducerMessageDTO.class);

		return new ResponseEntity<>("Successfully Consumed", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> consumeNewXMLOrder(String token, FulfillmentOrder newOrder) {

		FulfilmentOrderEntity entity = this.modelMapper.map(newOrder, FulfilmentOrderEntity.class);

		// separate all entities and add them into respective tables

		// source,Address,BillingInfo etc

		// to set this sourceId we need to first insert into source table

		SourceEntity sourceEntity = this.modelMapper.map(newOrder.getSource(), SourceEntity.class);

		sourceEntity = sourceRepo.save(sourceEntity);

		entity.setSourceId(sourceEntity.getSourceId());

		entity.setClientID(sourceEntity.getClientID());
		// insert into billingInfo

		BillingInfo billingInfo = new BillingInfo();

		billingInfo.setCustID(newOrder.getBillingAddress().getContact().getCustID());
		billingInfo.setFirstName(newOrder.getBillingAddress().getContact().getName().getFirstName());
		billingInfo.setLastName(newOrder.getBillingAddress().getContact().getName().getLastName());
		billingInfo.setSeperatorName0(newOrder.getBillingAddress().getContact().getName().getSeparatorName0());
		billingInfo.setSeperatorName1(newOrder.getBillingAddress().getContact().getName().getSeparatorName1());

		billingInfo.setDaytimePhoneNbr(newOrder.getBillingAddress().getContact().getDaytimePhoneNbr());
		billingInfo.setHomePhoneNbr(newOrder.getBillingAddress().getContact().getHomePhoneNbr());
		billingInfo.setAlternatePhoneNbr(newOrder.getBillingAddress().getContact().getAlternatePhoneNbr());
		billingInfo.setSendSMSMessage(newOrder.getBillingAddress().getContact().isSendSMSMessage());
		billingInfo.setEmailAddress(newOrder.getBillingAddress().getContact().getEmailAddress());
		billingInfo.setSeparatorContact0(newOrder.getBillingAddress().getContact().getSeparatorContact0());

		BillingInfoEntity billingInfoEntity = this.modelMapper.map(billingInfo, BillingInfoEntity.class);

		billingInfoEntity = billingInfoRepo.save(billingInfoEntity);

		

		entity.setCustID(billingInfo.getCustID());
		// then enter into address table

		AddressEntity addressEntity = this.modelMapper.map(newOrder.getBillingAddress().getContact().getAddress(),
				AddressEntity.class);
		addressEntity.setCustId(billingInfoEntity.getCustID());

		addressRepo.save(addressEntity);

		entity = repoXML.save(entity);

		return new ResponseEntity<>("Successfully Consumed", HttpStatus.OK);
	}

}
