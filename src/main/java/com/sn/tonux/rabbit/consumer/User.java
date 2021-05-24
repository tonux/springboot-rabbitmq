package com.sn.tonux.rabbit.consumer;


import com.sn.tonux.rabbit.config.MessagingConfig;
import com.sn.tonux.rabbit.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from queue "+orderStatus);
    }

}
