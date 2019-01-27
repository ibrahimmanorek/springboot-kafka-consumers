package com.ibrahim.springbootkafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.ibrahim.springbootkafkaconsumer.model.User;

@EnableKafka
@Configuration
public class KafkaConfiguration {
	
	
	@Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }
	
	@Bean
    public ConsumerFactory<String, User> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(), //configs
                new StringDeserializer(), //key
                new JsonDeserializer<>(User.class)); //value
    }
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	@Bean
    public ConsumerFactory<String, String> consumerFactoryString() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerFactoryString(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryString());
		return factory;
	}

}
