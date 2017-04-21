package org.maks;

/**
 * Created by user on 18.04.2017.
 */
public class ReadTest {
    public static void main(String[] args) {
        RSSVacanciesParser parser = new RSSVacanciesParser();

        Channel feed = parser.readFeed();
        System.out.println(feed);
        for (Vacancy message : feed.getVacancies()) {
            System.out.println(message);

        }
    }
}
