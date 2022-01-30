package com.futureaisoft.rabbitmq.listener;

import com.futureaisoft.model.Question;
import com.futureaisoft.rabbitmq.config.MessageConfig;
import com.futureaisoft.repository.QuestionRepository;
import com.futureaisoft.service.MyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessageListener {

@Autowired
    MyService service;

    @RabbitListener(queues = MessageConfig.question_save_queue)
    public void ListenToSaveQuestion(Question question){
        System.out.println("Message recieved from queue " + question);
        service.saveQuestion(question);
    }
}
