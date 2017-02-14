package com.mmc.entity;

import com.mmc.model.Message;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SGaurav on 05/01/2017.
 */
@Entity(name = "com.mmc.entity.MessageEntity")
@Table(name = "messages")
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = -529707323874505161L;

    @Id
    @Column(name = "message_id")
    private String messageId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "message")
    private String messageBody;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "sender")
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

    @Override
    public String toString() {
        return "MessageEntity{" +
                "messageId=" + messageId +
                ", subject='" + subject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", date=" + date +
                ", sender='" + sender + '\'' +
                '}';
    }

    public MessageEntity() {
    }

    public MessageEntity(Message message) {
        this.messageId = message.getMessageId();
        this.subject = message.getSubject();
        this.messageBody = message.getMessageBody();
        this.sender = message.getSender();
        this.date = message.getDate();
    }
}
