package org.maks;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.maks.domain.RSSItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.util.Date;

@Service
public class RSSVacanciesParser {

    private URL url = null;
    @Autowired
    private ObjectMapper xmlMapper;

    @Autowired
    private RestTemplate restTemplate;

    public RSSItems readRss(String url){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        return  restTemplate.exchange(url, HttpMethod.GET, request, RSSItems.class).getBody();
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

    @Scheduled(fixedRate = 6000)
    public void parseData(){
        System.out.println("I am alive!!!! time = "+new Date());
    }
}
