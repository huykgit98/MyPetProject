package org.maks;

import org.maks.dou.DouReciver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final DouReciver receiver;
    private final ConfigurableApplicationContext context;

    public CLRunner(DouReciver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(Application.queueName, "Hello from RabbitMQ!");;
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        context.close();
    }
}
