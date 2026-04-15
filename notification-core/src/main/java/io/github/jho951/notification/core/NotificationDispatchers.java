package io.github.jho951.notification.core;

import io.github.jho951.notification.api.NotificationChannel;
import io.github.jho951.notification.api.NotificationDispatchResult;
import io.github.jho951.notification.api.NotificationDispatcher;

import java.util.Collection;
import java.util.List;

public final class NotificationDispatchers {
    private static final NotificationDispatcher NOOP = message -> new NotificationDispatchResult(message, List.of());

    private NotificationDispatchers() {
    }

    public static NotificationDispatcher noop() {
        return NOOP;
    }

    public static NotificationDispatcher composite(Collection<? extends NotificationChannel> channels) {
        return new CompositeNotificationDispatcher(channels);
    }
}
