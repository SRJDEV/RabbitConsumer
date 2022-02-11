package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.AckMode;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MacysOrderMessageConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacysOrderMessageConsumerApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	
	}
	@Bean
	public MessageChannel pubsubInputChannel() {
		return new DirectChannel();
	}

	@Bean
	public PubSubInboundChannelAdapter messageChannelAdapter(
			@Qualifier("pubsubInputChannel") MessageChannel inputChannel, PubSubTemplate pubSubTemplate) {
		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "Macy-Topic-sub");
		adapter.setOutputChannel(inputChannel);
		adapter.setAckMode(AckMode.MANUAL);

		return adapter;
	}

	@Bean
	@ServiceActivator(inputChannel = "pubsubInputChannel")
	public MessageHandler messageReceiver() {
		return message -> {
			System.out.println("Message arrived! Payload: " + new String((byte[]) message.getPayload()));
			BasicAcknowledgeablePubsubMessage originalMessage = message.getHeaders()
					.get(GcpPubSubHeaders.ORIGINAL_MESSAGE, BasicAcknowledgeablePubsubMessage.class);
			originalMessage.ack();
		};
	}

}
