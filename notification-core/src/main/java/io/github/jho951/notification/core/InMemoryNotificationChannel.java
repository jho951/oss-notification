package io.github.jho951.notification.core;

import io.github.jho951.notification.api.NotificationChannel;
import io.github.jho951.notification.api.NotificationDelivery;
import io.github.jho951.notification.api.NotificationMessage;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public final class InMemoryNotificationChannel implements NotificationChannel {
    private final String name;
    private final List<NotificationMessage> messages = new CopyOnWriteArrayList<>();

    public InMemoryNotificationChannel(String name) {
        this.name = requireText(name, "name");
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public NotificationDelivery send(NotificationMessage message) {
        Objects.requireNonNull(message, "message");
        messages.add(message);
        return NotificationDelivery.delivered(name, "stored in memory");
    }

    public List<NotificationMessage> messages() {
        return List.copyOf(messages);
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value;
    }
}
