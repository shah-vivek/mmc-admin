package com.mmc.service;

import com.mmc.model.Notification;

import java.util.List;
/**
 * Created by SGaurav on 01/01/2017.
 */
public interface NotificationService {

    void add(Notification notification) throws Exception;

    void update(Notification notification) throws Exception;

    void delete(String id) throws Exception;

    List<Notification> list() throws Exception;

    Notification get(String id) throws Exception;
}
