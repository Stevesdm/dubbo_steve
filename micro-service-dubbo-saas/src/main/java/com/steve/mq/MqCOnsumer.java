package com.steve.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by SteveJobson on 2017/7/14.
 */
@Component
public class MqCOnsumer {



    @JmsListener(destination = "simple.topic")
    @SendTo("out.queue")
    public String receiveMsg(String msg) {
        System.out.println("get::::" + msg);
        return "receive:"+msg;
    }

    @JmsListener(destination = "simple.topic")
    @SendTo("out.queue")
    public String receiveMsg1(String msg) {
        System.out.println("get1::::" + msg);
        return "receive:"+msg;
    }

    @JmsListener(destination = "simple.topic")
    @SendTo("out.queue")
    public String receiveMsg2(String msg) {
        System.out.println("get2::::" + msg);
        return "receive:"+msg;
    }

}
