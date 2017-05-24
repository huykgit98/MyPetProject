package org.maks.common;


/**
 * RSSQuery class witch contains parameters of user request and user id.
 */
public class RSSQuery {

    private String id;
    private String language;
    private String city;
    private String company;
    private String keyWord;
    private String userQueryId;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserQueryId() {
        return userQueryId;
    }

    public void setUserQueryId(String userQueryId) {
        this.userQueryId = userQueryId;
    }
}
