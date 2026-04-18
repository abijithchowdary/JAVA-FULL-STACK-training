package com.pharmacy.notification.listener;

import com.pharmacy.notification.config.RabbitMQConfig;
import com.pharmacy.notification.dto.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationListener.class);

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void handleNotification(NotificationRequest request) {
        log.info("[NOTIFICATION] type={} to={} subject={}",
                request.getType(), request.getRecipientEmail(), request.getSubject());
        log.info("[NOTIFICATION] message={}", request.getMessage());
        // TODO: integrate JavaMailSender / Twilio / Firebase here
    }
}
