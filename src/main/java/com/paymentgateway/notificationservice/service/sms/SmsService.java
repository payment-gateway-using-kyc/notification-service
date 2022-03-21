package com.paymentgateway.notificationservice.service.sms;

import com.paymentgateway.notificationservice.model.Sms;
import com.paymentgateway.notificationservice.repository.SmsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SmsService {

    private final TwilioSmsSender twilioSmsSender;
    private final SmsRepository smsRepository;

    public Sms sendSms(Sms sms){
        twilioSmsSender.sendSms(sms);
        smsRepository.save(sms);
        return sms;
    }
}
