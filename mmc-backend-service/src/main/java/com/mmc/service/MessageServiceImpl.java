package com.mmc.service;

import com.mmc.entity.MessageEntity;
import com.mmc.model.Message;
import com.mmc.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 06/01/2017.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void send(Message message) throws Exception {

        MessageEntity messageEntity = new MessageEntity(message);
        messageEntity.setMessageId(UUID.randomUUID().toString());
        messageRepository.save(messageEntity);
    }

    public List<Message> get() throws Exception {

        Iterable<MessageEntity> messageEntities = messageRepository.findAll();
        List<Message> messageList = new ArrayList<Message>();
        for(MessageEntity messageEntity : messageEntities) {
            messageList.add(new Message(messageEntity));
        }
        return messageList;
    }

    public void reply(Message message , String replyTo) throws Exception {

    }
}
