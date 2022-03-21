package com.paymentgateway.notificationservice.service.email;

public interface EmailService {
    void send(String to,String subject, String message);
}
