package com.paymentgateway.notificationservice.repository;


import com.paymentgateway.notificationservice.model.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsRepository extends JpaRepository<Sms, String> {
}
