package com.yuan._1core.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "notification.service", havingValue = "sms")
public class SMSService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
