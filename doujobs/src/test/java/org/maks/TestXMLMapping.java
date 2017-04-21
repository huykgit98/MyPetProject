package org.maks;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;


public class TestXMLMapping {

    String testVacancy = "<item>\n" +
            "            <title>Full-stack Web Developer (SPA + .Net) в Boovatech, Киев</title>\n" +
            "            <link>https://jobs.dou.ua/companies/boovatech/vacancies/37204/?utm_source=jobsrss</link>\n" +
            "            <description>&lt;div class=\"requirements\"&gt;\n" +
            "                &lt;h3 class=\"g-h3\"&gt;\n" +
            "                Необходимые навыки\n" +
            "                &lt;/h3&gt;\n" +
            "                &lt;div class=\"text __r\"&gt;\n" +
            "                &lt;div&gt;&lt;p&gt;You:&lt;br&gt;— Are an excellent and enthusiastic .Net programmer, with experience\n" +
            "                with unit testing and ORM’s&lt;br&gt;— Familiar with JS front-end frameworks such as AngularJS or\n" +
            "                ReactJS&lt;br&gt;— Keen and quick to learn new programming technologies&lt;br&gt;— Enjoy engaging with\n" +
            "                others to improve the software design and implementation&lt;br&gt;— Share our ambition to write a great\n" +
            "                code and develop fantastic products&lt;/p&gt;\n" +
            "\n" +
            "                &lt;p&gt;Your Experience:&lt;br&gt;— 2+ years’ experience of developing object oriented enterprise\n" +
            "                applications based on .Net Framework&lt;br&gt;— 1+ years’ experience of developing SPA based on JS\n" +
            "                front-end frameworks such as AngularJS or ReactJS&lt;br&gt;— Good working knowledge of object oriented\n" +
            "                design patterns&lt;br&gt;— Experience with NHibernate is a big plus&lt;br&gt;— Experience with RDMS such\n" +
            "                as Oracle / MS SQL&lt;br&gt;— Experience with ASP.NET WebAPI and/or NodeJS is a plus&lt;br&gt;—\n" +
            "                Financial industry experience is a plus &lt;/p&gt;\n" +
            "\n" +
            "                &lt;p&gt;Your qualifications:&lt;br&gt;— Ideally a BSc degree in Computer Science or similar discipline&lt;br&gt;—\n" +
            "                Proven passion for developing bug-free software&lt;br&gt;— Inquisitive mind to learn and explore new\n" +
            "                development technologies and methods, algorithms, design patterns, unit testing and so on;&lt;br&gt;—\n" +
            "                Experience working in an Agile environment is a plus&lt;/p&gt;&lt;/div&gt;\n" +
            "                &lt;/div&gt;\n" +
            "                &lt;/div&gt;\n" +
            "                &lt;div class=\"bonuses\"&gt;\n" +
            "                &lt;h3 class=\"g-h3\"&gt;\n" +
            "                Предлагаем\n" +
            "                &lt;/h3&gt;\n" +
            "                &lt;div class=\"text\"&gt;\n" +
            "                &lt;p&gt;— Competitive salary level&lt;br&gt;— Opportunity to work with the new technologies and\n" +
            "                corporate level platforms&lt;br&gt;— Long-term own projects in Fintech sphere.&lt;br&gt;— Full Software\n" +
            "                development cycle&lt;br&gt;— Career possibilities with growing team&lt;br&gt;— Truly friendly\n" +
            "                environment and flexible schedule&lt;br&gt;— Paid training and conference days&lt;br&gt;— Modern and\n" +
            "                comfortable office close to the subway&lt;/p&gt;\n" +
            "                &lt;/div&gt;\n" +
            "                &lt;/div&gt;\n" +
            "                &lt;div class=\"duty\"&gt;\n" +
            "                &lt;h3 class=\"g-h3\"&gt;\n" +
            "                Обязанности\n" +
            "                &lt;/h3&gt;\n" +
            "                &lt;div class=\"text\"&gt;\n" +
            "                &lt;p&gt;For this position we are looking for outstanding professional, who will be able both: &lt;br&gt;—\n" +
            "                to design and to develop a web-based platform for our mainstream set of products (adaptiveCASH) with a\n" +
            "                modern cutting-edge technologies&lt;br&gt;— to build and to lead the Team of high-skilled web-developers\n" +
            "                for this purpose&lt;/p&gt;\n" +
            "                &lt;/div&gt;\n" +
            "                &lt;/div&gt;\n" +
            "                &lt;div class=\"project\"&gt;\n" +
            "                &lt;h3 class=\"g-h3\"&gt;\n" +
            "                О проекте\n" +
            "                &lt;/h3&gt;\n" +
            "                &lt;div class=\"text\"&gt;\n" +
            "                &lt;p&gt;adaptiveCASH — an enterprise-level set of cash management solutions for businesses with a\n" +
            "                massive cash turnover (Banks, Cash-in-Transit companies, Retail, etc.). More details you will find on\n" +
            "                &lt;a href=\"http://adaptivecash.com\" target=\"_blank\"&gt;adaptivecash.com&lt;/a&gt;&lt;/p&gt;\n" +
            "                &lt;/div&gt;\n" +
            "                &lt;/div&gt;\n" +
            "\n" +
            "                &lt;div&gt;\n" +
            "                &lt;a href=\"http://jobs.dou.ua/companies/boovatech/vacancies/37204/#reply-btn-id\"&gt;Откликнуться на\n" +
            "                вакансию&lt;/a&gt;\n" +
            "                &lt;/div&gt;\n" +
            "            </description>\n" +
            "            <pubDate>Sat, 15 Apr 2017 21:49:33 +0300</pubDate>\n" +
            "            <guid>https://jobs.dou.ua/companies/boovatech/vacancies/37204/?1492282173</guid>\n" +
            "        </item>";
    @Test
    public void tetVacancy() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Vacancy value =
                xmlMapper.readValue(testVacancy, Vacancy.class);
        System.out.println(value.getDescription());
    }

    @Test
    public void testVacancies() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Channel channel = xmlMapper.readValue(RSSVacanciesParser.readFile(), Channel.class);
        System.out.println(channel);
        Arrays.stream(channel.getVacancies()).forEach(System.out::println);

    }
}
