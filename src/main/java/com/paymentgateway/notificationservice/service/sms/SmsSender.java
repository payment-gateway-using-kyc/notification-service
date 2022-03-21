package com.paymentgateway.notificationservice.service.sms;

import com.paymentgateway.notificationservice.model.Sms;

public interface SmsSender {
    void sendSms(Sms sms);
}
