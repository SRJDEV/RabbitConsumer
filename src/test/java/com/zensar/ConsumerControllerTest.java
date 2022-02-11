package com.zensar;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.ProducerMessageDTO;
import com.zensar.entity.FulfilmentOrderEntity;
import com.zensar.service.MessageConsumerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConsumerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	MessageConsumerService service;
	
	
	@Test
	public void consumeJsonOrder() throws Exception {

		// mocking api that getting json msg from queue and saving in db


		  ProducerMessageDTO producerJsonDto = new
		  ProducerMessageDTO("ITEMMASTER_TEST","ADD","Mobile","iPhone13",
		  13.8,8.9,15.8,90.8,"imapgepath/iPhone13.jpeg","rfID",1,"Y","O");

		ResponseEntity<String> responseEntity = new ResponseEntity<String>("", HttpStatus.OK);
		
		Mockito.when(service.consumeJsonOrder(Mockito.anyString(), Mockito.any(ProducerMessageDTO.class)))
			.thenReturn(responseEntity);
		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/macy/consumer/order")

				.accept(org.springframework.http.MediaType.APPLICATION_JSON).header("Authorization", "xyzx")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
	@Test
	public void consumeXmlOrder() throws Exception {

		// mocking api that getting json msg from queue and saving in db


		FulfillmentOrder fulfillmentOrder  = new FulfillmentOrder(1010, 2, 100, 0, "Electrical", null, null, null, null, 0, null, 0, 0, null, null, null);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("", HttpStatus.OK);
		
		Mockito.when(service.consumeXMLOrder("xyzz",fulfillmentOrder))
			.thenReturn(responseEntity);
		

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/macy/consumer/orderxml")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON).header("Authorization", "xyzx")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	

		MockHttpServletResponse response = result.getResponse();
		String s =	response.getContentAsString();

		System.out.println("Response Test :"+s);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}


}
