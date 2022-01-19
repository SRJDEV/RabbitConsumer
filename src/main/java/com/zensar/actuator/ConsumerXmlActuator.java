package com.zensar.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.zensar.repository.MessageRepositoryConsumer;
import com.zensar.repository.XMLRepository;

@Component
public class ConsumerXmlActuator implements InfoContributor {

	@Autowired
	XMLRepository xmlRepo;
	
	@Autowired
	MessageRepositoryConsumer jsonRepo;

	@Override
	public void contribute(Builder builder) {
		
		builder.withDetail("Total xml orders consumed",xmlRepo.count());
		builder.withDetail("Total Json orders consumed", jsonRepo.count());
	}
	
	
	
}
