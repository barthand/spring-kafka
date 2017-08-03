package com.codenotfound.kafka.stringconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class StringReceiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(StringReceiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "${kafka.topic.string}", containerFactory = "stringKafkaListenerContainerFactory")
  public void receive(String car) {
    LOGGER.info("received car='{}'", car);
    latch.countDown();
  }
}
