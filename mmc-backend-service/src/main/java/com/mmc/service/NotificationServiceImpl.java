package com.mmc.service;

import com.mmc.entity.NotificationEntity;
import com.mmc.model.Notification;
import com.mmc.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SGaurav on 01/01/2017.
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public void add(Notification notification) throws Exception {
        String id = UUID.randomUUID().toString();
        NotificationEntity notificationEntity = new NotificationEntity(notification);
        notificationEntity.setId(id);
        notificationRepository.save(notificationEntity);
    }

    public void update(Notification notification) throws Exception {
        NotificationEntity notificationEntity = new NotificationEntity(notification);
        notificationRepository.save(notificationEntity);
    }

    public  void delete(String id) throws Exception {
        notificationRepository.delete(id);
    }

    public Notification get(String id) throws Exception {
        return new Notification(notificationRepository.findOne(id));
    }

    public List<Notification> list() throws Exception {
        List<Notification> notificationList = new ArrayList<Notification>();

        Iterable<NotificationEntity> notificationEntities = notificationRepository.findAll();

        for(NotificationEntity notificationEntity : notificationEntities) {
            notificationList.add(new Notification(notificationEntity));
        }
        return  notificationList;
    }
}
