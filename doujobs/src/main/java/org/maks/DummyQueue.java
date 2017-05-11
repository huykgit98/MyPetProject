package org.maks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DummyQueue {
    @Value("https://jobs.dou.ua/vacancies/feeds/?category=Java")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
