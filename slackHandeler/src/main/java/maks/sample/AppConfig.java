package maks.sample;

import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * Config for spring boot
 */
@SpringBootApplication
@PropertySource("classpath:/app.properties")
//@PropertySource("file:${app.home}/app.properties")
public class AppConfig {

    @Value("${app.name}")
    private static String appName;

    @Autowired
    Environment env;

    public static void main(String[] args) {
        System.out.println("name " + appName);
        ApplicationContext ctx = SpringApplication.run(AppConfig.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleQueueListener queueListener = ctx.getBean(SimpleQueueListener.class);
        TestComponent testComponent = (TestComponent) ctx.getBean("testComponent");
        System.out.println(testComponent);
        SlackSession session = (SlackSession) ctx.getBean("slackSession");
        System.out.println(session);

    }




    @Bean(name = "slackSession")
    public SlackSession slackSession() {
        String botKey = env.getProperty("slack.bot.key");
//        SlackSession session = SlackSessionFactory.createWebSocketSlackSession("xoxb-171912953969-0zkBqLXZygMccyAMj0QRhMp0");
        SlackSession session = SlackSessionFactory.createWebSocketSlackSession(botKey);
        return session;
    }

}
