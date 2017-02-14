package com.mmc.service;

import com.mmc.model.Message;

import java.util.List;

/**
 * Created by SGaurav on 06/01/2017.
 */
public interface MessageService {

    void send(Message message) throws Exception;

    List<Message> get() throws Exception;

    void reply(Message message , String replyTo) throws Exception;

}
