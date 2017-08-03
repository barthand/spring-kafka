package com.codenotfound.kafka.stringproducer;

import com.codenotfound.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class StringSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(StringSender.class);

  @Value("${kafka.topic.string}")
  private String topic;

  @Autowired
  private KafkaTemplate<String, String> stringKafkaTemplate;

  public void send(Car car) {
    LOGGER.info("sending car='{}'", car.toString());
    stringKafkaTemplate.send(topic, "[STRING] " + car.toString());
  }
}
