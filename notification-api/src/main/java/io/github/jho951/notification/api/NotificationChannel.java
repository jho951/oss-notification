package io.github.jho951.notification.api;

public interface NotificationChannel {
    String name();

    NotificationDelivery send(NotificationMessage message);
}
