package com.notificationpersistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NotificationPersistenceConfigController {

    @Autowired
    private Environment environment;

    @GetMapping("/configs")
    public Map getConfigs() {
        Map<String, String> configsMap = new LinkedHashMap<>();
        configsMap.put("Notifications Persistence Config Property 1", environment.getProperty("notifications.persistence.configproperty1"));
        configsMap.put("Notifications Persistence Config Property 2", environment.getProperty("notifications.persistence.configproperty2"));

        return configsMap;
    }

}
