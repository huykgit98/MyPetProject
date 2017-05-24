package org.maks;

import org.maks.service.RSSVacanciesParser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private RSSVacanciesParser vacanciesParser;
    private final ConfigurableApplicationContext context;

    public Runner(RSSVacanciesParser vacanciesParser, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.vacanciesParser = vacanciesParser;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");

        rabbitTemplate.convertAndSend("dou-vac", "Hello from RabbitMQ! Ohoh o");
/*
        rabbitTemplate.convertAndSend("dou-vac", vacanciesParser
                .readRss("https://jobs.dou.ua/vacancies/feeds/?category=Java")
        .getChannel().getVacancies()[2]);
*/

//        context.close();
}
}
