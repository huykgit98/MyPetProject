package org.maks;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import static sun.plugin.javascript.navig.JSType.Link;

@JacksonXmlRootElement(localName = "Channel", namespace = "http://www.w3.org/2005/Atom")
public class Channel {

    @JacksonXmlProperty(localName = "title")
    private String title;
    @JacksonXmlProperty( isAttribute = true)
    private String link;
    private String description;
    private String language;
    private String lastBuildDate;

    public Channel() {
    }

    public Channel(String title, String link, String description, String language, String lastBuildDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.lastBuildDate = lastBuildDate;

    }

    @JacksonXmlProperty(localName = "item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Vacancy[] vacancies ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public Vacancy[] getVacancies() {
        return vacancies;
    }

    public void setVacancies(Vacancy[] vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", vacancies size =" + vacancies.length +
                '}';
    }
}
