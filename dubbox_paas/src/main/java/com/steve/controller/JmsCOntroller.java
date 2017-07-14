package com.steve.controller;

import com.steve.activemq.MessageQ;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;

/**
 * Created by SteveJobson on 2017/7/14.
 */
@RestController
public class JmsCOntroller {

    @Autowired
    MessageQ messageQ;

    @RequestMapping(value = "/send")
    public String sendMsg(@RequestParam(value = "message") String msg){
//        Destination destination = new ActiveMQQueue("test.queue");
        Topic topic = new ActiveMQTopic("simple.topic");
        messageQ.sendMessageTopic(topic,msg);
        return msg + "success sendmeibanfa";
    }

}
