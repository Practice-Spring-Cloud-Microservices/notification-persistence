package com.notificationpersistence.service;

import com.notificationpersistence.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationPersistenceService {

    Page<Notification> findAll(Pageable pageable);

    Notification findById(int theId);

    Notification save(Notification theNotification);

}
