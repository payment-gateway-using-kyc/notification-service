package com.paymentgateway.notificationservice.service.sms;

import com.paymentgateway.notificationservice.configuration.TwilioConfiguration;
import com.paymentgateway.notificationservice.model.Sms;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TwilioSmsSender implements SmsSender {

    private final TwilioConfiguration twilioConfiguration;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    @Override
    public void sendSms(Sms sms) {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        if(phoneNumberValidator.test(sms.getPhoneNumber())){
            PhoneNumber to = new PhoneNumber(sms.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = sms.getMessage();
            MessageCreator messageCreator = new MessageCreator(to,from, message);
            messageCreator.create();
            LOGGER.info("Send sms {}"+ sms);
        }else {
            throw new IllegalArgumentException("Phone number ["+ sms.getPhoneNumber()+"] is invalid.");
        }

    }

}
