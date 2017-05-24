package org.maks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.maks.common.RSSQuery;
import org.maks.common.RSSQueryBuilder;
import org.maks.domain.Vacancy;
import org.maks.dto.RSSItems;
import org.maks.dto.VacancyDto;
import org.maks.service.RSSVacanciesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class RSSVacanciesParserTest {
    @Autowired
    private RSSVacanciesParser vacanciesParser;
    @Autowired
    private DummyQueue dummyQueue;

    @Test
    public void readRssTest() throws Exception {
        String url = dummyQueue.getUrl();
        RSSItems items = vacanciesParser.readRss(url);
        assertTrue(0 < items.getChannel().getVacancies().length);
    }

    @Test
    public void testRssQuery(){
        RSSQueryBuilder rssQueryBuilder = new RSSQueryBuilder();
        RSSQuery rssQuery = rssQueryBuilder.city("Львів").language("java").build();
        RSSItems rssItems  = vacanciesParser.readRss(rssQuery);
        List<VacancyDto> list=Arrays.asList(rssItems.getChannel().getVacancies());
        list.forEach((vac)->{
            System.out.println(vac.getDescription());
        });
        assertTrue(list.size() >= 1);

    }


}