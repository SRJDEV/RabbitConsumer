package com.zensar.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.zensar.repository.MessageRepositoryConsumer;
import com.zensar.repository.XMLRepository;


public class ConsumerJsonActuator implements InfoContributor {

	@Autowired
	MessageRepositoryConsumer jsonRepo;

	@Override
	public void contribute(Builder builder) {

		builder.withDetail("Total Json orders consumed", jsonRepo.count());

	}
}
