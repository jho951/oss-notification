package io.github.jho951.notification.api;

import java.util.List;
import java.util.Objects;

public record NotificationDispatchResult(
        NotificationMessage message,
        List<NotificationDelivery> deliveries
) {
    public NotificationDispatchResult {
        message = Objects.requireNonNull(message, "message");
        deliveries = deliveries == null ? List.of() : List.copyOf(deliveries);
    }

    public boolean delivered() {
        return deliveries.stream().anyMatch(NotificationDelivery::delivered);
    }

    public long deliveryCount() {
        return deliveries.size();
    }

    public long failureCount() {
        return deliveries.stream().filter(delivery -> !delivery.delivered()).count();
    }

    public static NotificationDispatchResult empty(NotificationMessage message) {
        return new NotificationDispatchResult(message, List.of());
    }
}
