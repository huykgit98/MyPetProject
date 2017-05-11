package org.maks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.maks.domain.RSSItems;
import org.maks.domain.Vacancy;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class VacancySender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Queue queue;

    @Autowired
    private RSSVacanciesParser vacanciesParser;

    @Autowired
    private DummyQueue dummyQueue;

    @Scheduled(fixedDelay = 10000, initialDelay = 500)
    public void send() {
        RSSItems rssItems = vacanciesParser.readRss(dummyQueue.getUrl());
        List<Vacancy> vacancies = Arrays.asList(rssItems.getChannel().getVacancies());
        try {
            for (Vacancy vacancy : vacancies) {

                String message = objectMapper.writeValueAsString(vacancy);
                template.convertAndSend(queue.getName(), message);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
