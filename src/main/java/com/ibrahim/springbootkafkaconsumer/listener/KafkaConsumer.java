package com.ibrahim.springbootkafkaconsumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.ibrahim.springbootkafkaconsumer.model.User;

@Component
public class KafkaConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);
	
//	@KafkaListener(topics = "ibrahim", groupId = "json", containerFactory = "userKafkaListenerFactory")
//	public void consume(@Payload User user,
//			@Headers MessageHeaders headers) {
//		System.out.println("Consume Json "+user.getName() + " "+user.getDept()+" "+user.getSalary());
//		headers.keySet().forEach(key -> {
//			LOG.info("{}: {}", key, headers.get(key));
//		});
//	}

	
	@KafkaListener(topics = "manorek", containerFactory = "kafkaListenerFactoryString")
	  public void receive(String payload) {
	    LOG.info("received payload='{}'", payload);
	    System.out.println(">>> "+payload);
	  }

}
