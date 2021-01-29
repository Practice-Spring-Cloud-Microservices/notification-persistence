package com.notificationpersistence.controller;

import com.notificationpersistence.entity.Notification;
import com.notificationpersistence.service.NotificationPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NotificationPersistenceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;
    private NotificationPersistenceService notificationPersistenceService;

    @Autowired
    public NotificationPersistenceController(Environment environment, NotificationPersistenceService notificationPersistenceService) {
        this.environment = environment;
        this.notificationPersistenceService = notificationPersistenceService;
    }

    @GetMapping("/notifications")
    public ResponseEntity<Map> findAll(Pageable pageable) {
        logger.info("request uri = {}", ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        Page<Notification> notifications = notificationPersistenceService.findAll(pageable);
        return wrapUpResponse("notifications", notifications);
    }

    @GetMapping("/notifications/{notificationId}")
    public ResponseEntity<Map> finById(@PathVariable int notificationId) {
        logger.info("request uri = {}", ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        Notification theNotification = notificationPersistenceService.findById(notificationId);
        return wrapUpResponse("notification", theNotification);
    }

    @PostMapping("/notifications")
    public ResponseEntity<Map> persistNotification(@RequestBody Notification theNotification) {
        logger.info("request uri = {}", ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
        theNotification.setId(0);
        notificationPersistenceService.save(theNotification);

        return wrapUpResponse("notification", theNotification);
    }

    private ResponseEntity<Map> wrapUpResponse(String responseContentKey, Object responseContent) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("handler_server", environment.getProperty("server.port"));
        if (responseContent != null) {
            resultMap.put(responseContentKey, responseContent);
        }

        HttpStatus status = responseContent != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(resultMap, status);
    }

}
