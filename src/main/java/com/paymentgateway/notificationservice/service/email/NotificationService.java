package com.paymentgateway.notificationservice.service.email;

import com.paymentgateway.notificationservice.model.Notification;
import com.paymentgateway.notificationservice.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final EmailServiceImpl emailService;

    private void saveNotification(Notification notification){
        notificationRepository.save(notification);
    }

    @Transactional
    public Notification sendNotification(Notification notification){
        emailService.send(
                notification.getEmail(),
                notification.getSubject(),
                emailService.buildEmailBody(
                        notification.getUsername(),
                        notification.getMessage())
        );

        saveNotification(notification);
        return notification;
    }

}
