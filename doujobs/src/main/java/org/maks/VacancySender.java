package org.maks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.maks.domain.Vacancy;
import org.maks.dto.RSSItems;
import org.maks.dto.VacancyDto;
import org.maks.repository.VacancyRepository;
import org.maks.service.RSSVacanciesParser;
import org.maks.service.VacancyService;
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
    VacancyRepository vacancyRepository;

    @Autowired
    private DummyQueue dummyQueue;

    @Autowired private VacancyService vacancyService;


    public void send(List<VacancyDto> vacancyDtos) {

        try {
            for (VacancyDto vacancyDto : vacancyDtos) { //TODO change method to sending array, not each element
                String message = objectMapper.writeValueAsString(vacancyDto);
                template.convertAndSend(queue.getName(), message);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(fixedDelayString = "${dou.jobs.millisecond}" , initialDelay = 500)
    public void executeParsing(){
        RSSItems rssItems = vacanciesParser.readRss(dummyQueue.getUrl());
        List<VacancyDto> vacancies = Arrays.asList(rssItems.getChannel().getVacancies());
        send(vacancies);
        saveToDb(vacancyService.dtoToDomain(vacancies));

    }

    public void saveToDb(List<Vacancy> vacancies){
        List<Vacancy> newVacancies = vacancyService.checkUnique(vacancies);
        vacancyRepository.save(newVacancies);
    }
}
