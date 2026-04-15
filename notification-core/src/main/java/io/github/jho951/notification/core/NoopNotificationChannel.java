package io.github.jho951.notification.core;

import io.github.jho951.notification.api.NotificationChannel;
import io.github.jho951.notification.api.NotificationDelivery;
import io.github.jho951.notification.api.NotificationErrorCode;
import io.github.jho951.notification.api.NotificationMessage;

public final class NoopNotificationChannel implements NotificationChannel {
    private final String name;

    public NoopNotificationChannel(String name) {
        this.name = name == null || name.isBlank() ? "noop" : name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public NotificationDelivery send(NotificationMessage message) {
        return NotificationDelivery.failed(name, NotificationErrorCode.UNSUPPORTED_TARGET, "noop channel");
    }
}
