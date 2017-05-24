package org.maks.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.maks.common.RSSQuery;
import org.maks.dto.RSSItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class RSSVacanciesParser {


    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private ObjectMapper xmlMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("https://jobs.dou.ua/vacancies/feeds/?")
    private String baseUrl;

    public RSSItems readRss(String url){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        return  restTemplate.exchange(url, HttpMethod.GET, request, RSSItems.class).getBody();
    }

    public RSSItems readRss(RSSQuery rssQuery){
        String url = createUrl(rssQuery);
        return readRss(url);
    }

    private  String  createUrl(RSSQuery rssQuery){
        StringBuilder url = new StringBuilder();
        url.append(baseUrl);
        if(rssQuery.getCity()!=null){
            url.append("cities=").append(rssQuery.getCity());
        }
        if(rssQuery.getLanguage()!=null){
            addImpersandIfNesesary(url);
            url.append("category=").append(rssQuery.getLanguage());
        }
        if(rssQuery.getCompany()!=null){
            addImpersandIfNesesary(url);
            url.append("search=").append(rssQuery.getCompany());
        }
        if(rssQuery.getKeyWord()!=null){
            addImpersandIfNesesary(url);
            if(url.toString().contains("search")){
                url.append("+").append(rssQuery.getKeyWord());
            }else{
                url.append("search=").append(rssQuery.getKeyWord());
            }
        }
        return url.toString();
    }

    private void addImpersandIfNesesary(StringBuilder url) {
        if(!url.toString().endsWith("?")){
            url.append("&");
        }
    }


    public static  InputStream readFile(){
        File file = new File("C:\\Users\\user\\IdeaProjects\\MyPetProject\\doujobs\\src\\main\\resources\\testRSS2.xml");
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream(file);
            return inputStream;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
