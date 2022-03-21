package com.paymentgateway.notificationservice.controller;

import com.paymentgateway.notificationservice.model.Notification;
import com.paymentgateway.notificationservice.model.Sms;
import com.paymentgateway.notificationservice.service.email.NotificationService;
import com.paymentgateway.notificationservice.service.sms.SmsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    private final SmsService smsService;

    @PostMapping("/send-email")
    public ResponseEntity<Void> notificationByEmail(@RequestBody Notification notification){
        notificationService.sendNotification(notification);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/send-sms")
    public ResponseEntity<Void> sendSms(@Valid @RequestBody Sms sms){
        smsService.sendSms(sms);
        return ResponseEntity.ok().build();
    }


}
