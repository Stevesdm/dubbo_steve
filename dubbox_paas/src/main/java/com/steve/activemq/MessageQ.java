package com.steve.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

/**
 * Created by SteveJobson on 2017/7/14.
 */
@Service
public class MessageQ {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessageTopic(Topic topic, final String message) {
        jmsTemplate.convertAndSend(topic, message);
    }


}
