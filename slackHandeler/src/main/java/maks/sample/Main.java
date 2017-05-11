package maks.sample;


import com.ullink.slack.simpleslackapi.SlackAttachment;
import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackPreparedMessage;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;

import java.io.IOException;

public class Main {
/*    public static void main(String[] args) throws IOException {
        SlackSession session = SlackSessionFactory.createWebSocketSlackSession("*****");
        session.connect();
        SlackChannel channel = session.findChannelByName("general"); //make sure bot is a member of the channel.
//        session.sendMessage(channel, "This message contains a URL http://foo.com/" );
//        session.sendMessage(channel, "This message contains a URL https://habrahabr.ru/company/ods/blog/325432/" );
        session.sendMessage(channel, "Job opportunity \n https://www.freelancer.com.ru/projects/Graphic-Design/Design-project-13795797/" );
        sendUsingPreparedMessage(session);
        session.disconnect();

    }*/

    public static void sendUsingPreparedMessage(SlackSession session)
    {
        //get a channel
        SlackChannel channel = session.findChannelByName("general");

        SlackAttachment attachment = new SlackAttachment("Attnetion", "This is Test Message", "Random text \n https://dou.ua/lenta/interviews/twitter-for-ukrainian-dev/", " Rather than hardcoding some prop");
        attachment.setColor("#36a64f");
        //build a message object
        SlackPreparedMessage preparedMessage = new SlackPreparedMessage.Builder()
                .withMessage("Hey, this is a message")
                .withUnfurl(false)
                .addAttachment(attachment)
                .addAttachment(new SlackAttachment())
                .build();

        session.sendMessage(channel, preparedMessage);
    }
}
