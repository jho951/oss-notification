package io.github.jho951.notification.core;

import io.github.jho951.notification.api.NotificationChannel;
import io.github.jho951.notification.api.NotificationDelivery;
import io.github.jho951.notification.api.NotificationDispatchResult;
import io.github.jho951.notification.api.NotificationDispatcher;
import io.github.jho951.notification.api.NotificationErrorCode;
import io.github.jho951.notification.api.NotificationMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public final class CompositeNotificationDispatcher implements NotificationDispatcher {
    private final List<NotificationChannel> channels;

    public CompositeNotificationDispatcher(Collection<? extends NotificationChannel> channels) {
        Objects.requireNonNull(channels, "channels");
        this.channels = List.copyOf(channels);
    }

    @Override
    public NotificationDispatchResult dispatch(NotificationMessage message) {
        Objects.requireNonNull(message, "message");

        List<NotificationDelivery> deliveries = new ArrayList<>();
        for (NotificationChannel channel : channels) {
            try {
                deliveries.add(channel.send(message));
            } catch (RuntimeException ex) {
                deliveries.add(NotificationDelivery.failed(
                        channel.name(),
                        NotificationErrorCode.TRANSPORT_ERROR,
                        ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage()
                ));
            }
        }
        return new NotificationDispatchResult(message, deliveries);
    }

    public List<NotificationChannel> channels() {
        return channels;
    }
}
