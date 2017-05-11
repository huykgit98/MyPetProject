package org.maks.dou;

import org.maks.dou.Vacancy;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@RabbitListener(queues = "vacancy-queue")
public class DouReciver {



    @RabbitHandler
    public void receive(String in) {
        System.out.println("Received from dou " );
        System.out.println(" [x] Received '" + in + "'");

    }

}
