package com.ibrahim.springbootkafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class SpringbootkafkaconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootkafkaconsumerApplication.class, args);
	}

}

