package org.maks.common;


public class RSSQueryBuilder {

    private String language;
    private String city;
    private String company;
    private String keyWord;

    public RSSQueryBuilder language(String lanquage){
        this.language = lanquage;
        return this;
    }

    public RSSQueryBuilder city(String city){
        this.city = city;
        return this;
    }

    public RSSQueryBuilder company(String company){
        this.company =company;
        return this;
    }

    public  RSSQueryBuilder keyWord(String keyWord){
        this.keyWord = keyWord;
        return this;
    }

    public RSSQuery build(){
        RSSQuery rssQuery = new RSSQuery();
        rssQuery.setCity(city);
        rssQuery.setCompany(company);
        rssQuery.setKeyWord(keyWord);
        rssQuery.setLanguage(language);
        return rssQuery;
    }
}
