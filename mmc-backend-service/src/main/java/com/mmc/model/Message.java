package com.mmc.model;

import com.mmc.entity.MessageEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SGaurav on 05/01/2017.
 */
public class Message implements Serializable {

    private String messageId;

    private String subject;

    private String messageBody;

    private Date date;

    private String sender;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Message() {
    }

    public Message(MessageEntity messageEntity) {
        this.messageId = messageEntity.getMessageId();
        this.subject = messageEntity.getSubject();
        this.messageBody = messageEntity.getMessageBody();
        this.sender = messageEntity.getSender();
        this.date = messageEntity.getDate();
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", subject='" + subject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", date=" + date +
                ", sender='" + sender + '\'' +
                '}';
    }
}
