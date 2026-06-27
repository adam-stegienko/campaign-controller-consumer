package com.adam_stegienko.campaign_controller_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CampaignControllerConsumer {

  public static void main(String[] args) {
    SpringApplication.run(CampaignControllerConsumer.class, args);
  }

}
