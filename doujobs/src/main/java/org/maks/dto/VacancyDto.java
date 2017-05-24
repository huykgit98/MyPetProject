package org.maks.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.data.mongodb.core.mapping.Document;

@JacksonXmlRootElement(localName = "item")
public class VacancyDto {

    private String title;
    private String link;
    private String pubDate;
    private String guid;
    private String description;

    public VacancyDto() {
    }

    public VacancyDto(String title, String link, String pubDate, String guid, String description) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.guid = guid;
        this.description = description;
    }

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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "VacancyDto{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", guid='" + guid + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
