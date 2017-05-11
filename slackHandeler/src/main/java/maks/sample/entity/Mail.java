package maks.sample.entity;


public class Mail {
    private String to;
    private String body;

    public Mail(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public Mail() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "to='" + to + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
