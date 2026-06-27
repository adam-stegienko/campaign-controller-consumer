package com.adam_stegienko.campaign_controller_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue}")
    private String queue;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    @Value("${rabbitmq.dlx}")
    private String dlx;

    @Value("${rabbitmq.error-queue}")
    private String errorQueue;

    @Value("${rabbitmq.error-routing-key}")
    private String errorRoutingKey;

    @Bean
    public DirectExchange campaignExchange() {
        return new DirectExchange(exchange, true, false);
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(dlx, true, false);
    }

    @Bean
    public Queue campaignQueue() {
        return QueueBuilder.durable(queue).build();
    }

    @Bean
    public Queue campaignErrorQueue() {
        return QueueBuilder.durable(errorQueue).build();
    }

    @Bean
    public Binding campaignQueueBinding() {
        return BindingBuilder.bind(campaignQueue()).to(campaignExchange()).with(routingKey);
    }

    @Bean
    public Binding errorQueueBinding() {
        return BindingBuilder.bind(campaignErrorQueue()).to(deadLetterExchange()).with(errorRoutingKey);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .connectTimeout(Duration.ofSeconds(10))
                .readTimeout(Duration.ofSeconds(30))
                .build();
    }
}
