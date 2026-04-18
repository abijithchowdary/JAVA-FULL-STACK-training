package com.pharmacy.notification.listener;

import com.pharmacy.notification.dto.NotificationRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class NotificationListenerTest {

    @Spy
    NotificationListener notificationListener;

    @Test
    void handleNotification_doesNotThrow() {
        NotificationRequest req = new NotificationRequest();
        req.setRecipientEmail("user@example.com");
        req.setSubject("Order Placed");
        req.setMessage("Your order has been placed");
        req.setType("ORDER_PLACED");
        assertDoesNotThrow(() -> notificationListener.handleNotification(req));
    }

    @Test
    void handleNotification_withNullFields_doesNotThrow() {
        NotificationRequest req = new NotificationRequest();
        assertDoesNotThrow(() -> notificationListener.handleNotification(req));
    }
}
