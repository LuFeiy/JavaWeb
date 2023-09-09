package com.yuan._1core.bean;

import org.springframework.stereotype.Component;

@Component
//@ConditionalOnMissingBean(NotificationService.class) // 默认实现类
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
