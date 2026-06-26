package com.adam_stegienko.campaign_controller_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.adam_stegienko.campaign_controller_consumer"})
@ComponentScan(basePackages = {"com.adam_stegienko.campaign_controller_consumer.controller"})
@ComponentScan(basePackages = {"com.adam_stegienko.campaign_controller_consumer.services"})
@ComponentScan(basePackages = {"com.adam_stegienko.campaign_controller_consumer.config"})
@ComponentScan(basePackages = {"com.adam_stegienko.campaign_controller_consumer.dto"})
@EnableScheduling
public class CampaignControllerConsumer {

  public static void main(String[] args) {
    SpringApplication.run(CampaignControllerConsumer.class, args);
  }

}
