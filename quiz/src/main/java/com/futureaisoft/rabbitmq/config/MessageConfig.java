package com.futureaisoft.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    public static final String question_save_queue = "question_save_queue";
    public static final String question_save_exchange = "question_save_exchange";
    public static final String routingkey = "question_routingkey";

    @Bean
    public Queue queue() {

        return new Queue(question_save_queue);

    }

    @Bean
    public TopicExchange exchange() {

        return new TopicExchange(question_save_exchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {

        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return  rabbitTemplate;
    }



}
