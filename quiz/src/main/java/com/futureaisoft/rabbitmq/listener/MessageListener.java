package com.futureaisoft.rabbitmq.listener;

import com.futureaisoft.model.Question;
import com.futureaisoft.rabbitmq.config.MessageConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MessageConfig.question_save_queue)
    public void ListenToSaveQuestion(Question question){
        System.out.println("Message recieved from queue " + question);

    }
}
