package io.github.jho951.notification.api;

import java.time.Instant;
import java.util.Objects;

public record NotificationDelivery(
        String channel,
        NotificationDeliveryStatus status,
        NotificationErrorCode errorCode,
        String detail,
        Instant deliveredAt
) {
    public NotificationDelivery {
        channel = requireText(channel, "channel");
        status = Objects.requireNonNullElse(status, NotificationDeliveryStatus.DELIVERED);
        errorCode = Objects.requireNonNullElse(errorCode, NotificationErrorCode.NONE);
        detail = detail == null ? "" : detail;
        deliveredAt = Objects.requireNonNullElseGet(deliveredAt, Instant::now);
    }

    public static NotificationDelivery delivered(String channel, String detail) {
        return new NotificationDelivery(channel, NotificationDeliveryStatus.DELIVERED, NotificationErrorCode.NONE, detail, Instant.now());
    }

    public static NotificationDelivery failed(String channel, NotificationErrorCode errorCode, String detail) {
        return new NotificationDelivery(channel, NotificationDeliveryStatus.FAILED, errorCode, detail, Instant.now());
    }

    public boolean delivered() {
        return status == NotificationDeliveryStatus.DELIVERED;
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value;
    }
}
