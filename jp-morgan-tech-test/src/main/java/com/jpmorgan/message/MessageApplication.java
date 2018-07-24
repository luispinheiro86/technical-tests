package com.jpmorgan.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpmorgan.message.model.BaseMessage;
import com.jpmorgan.message.model.Message;
import com.jpmorgan.message.model.MessageTypeOne;
import com.jpmorgan.message.model.Product;
import com.jpmorgan.message.model.Sale;
import com.jpmorgan.message.service.MessageService;

@SpringBootApplication
public class MessageApplication implements CommandLineRunner {
	
	@Autowired
	private MessageService messageService;
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MessageApplication.class); 	
		app.run(args);
	}
	
	@Override
	public void run(String... args) {
		
		Product p = new Product("Apple");
		Sale s = new Sale(p, 10.00);
		Message m = new Message(s);
		
		messageService.processMessage(m);
		
		for(int i = 0; i < 21; i++) {
			Product prod = new Product("Apple_" + i);
			Sale sale = new Sale(prod, new Double(i + i));
			Message msg = new Message(sale);
			messageService.processMessage(msg);
		}
		
		
		
//		MessageTypeOne mto = new MessageTypeOne(sale);
		
//		List<? extends BaseMessage> messages = new ArrayList<>();
		
//		messages.add(mto);
		
//		messageProcessingService.processMessages(messages);
	}
}
