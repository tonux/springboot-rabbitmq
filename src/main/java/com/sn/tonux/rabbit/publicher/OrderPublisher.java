package com.sn.tonux.rabbit.publicher;


import com.sn.tonux.rabbit.config.MessagingConfig;
import com.sn.tonux.rabbit.dto.Order;
import com.sn.tonux.rabbit.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderPublisher {

   @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());

        //restarantservice
        //payment service

        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in "+restaurantName);

        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);

        return "SUCCESS!!!";
    }
}

























