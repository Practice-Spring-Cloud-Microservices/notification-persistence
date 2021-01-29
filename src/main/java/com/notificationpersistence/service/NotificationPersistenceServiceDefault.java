package com.notificationpersistence.service;

import com.notificationpersistence.dao.NotificationRepository;
import com.notificationpersistence.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationPersistenceServiceDefault implements NotificationPersistenceService {

    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationPersistenceServiceDefault(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    @Transactional
    public Page<Notification> findAll(Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Notification findById(int theId) {
        return notificationRepository.findById(theId).orElse(null);
    }

    @Override
    @Transactional
    public Notification save(Notification theNotification) {
        return notificationRepository.save(theNotification);
    }
}
