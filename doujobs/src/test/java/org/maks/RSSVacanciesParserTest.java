package org.maks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.maks.domain.RSSItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class RSSVacanciesParserTest {
    @Autowired
    private RSSVacanciesParser vacanciesParser;
    @Autowired
    DummyQueue dummyQueue;

    @Test
    public void readRssTest() throws Exception {
        String url = dummyQueue.getUrl();
        RSSItems items = vacanciesParser.readRss(url);
        assertTrue(0 < items.getChannel().getVacancies().length);
    }

}