package io.github.jho951.notification.api;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public record NotificationMessage(
        String recipient,
        String subject,
        String body,
        NotificationPriority priority,
        Map<String, String> attributes,
        Instant occurredAt
) {
    public NotificationMessage {
        recipient = requireText(recipient, "recipient");
        subject = requireText(subject, "subject");
        body = requireText(body, "body");
        priority = Objects.requireNonNullElse(priority, NotificationPriority.NORMAL);
        attributes = attributes == null
                ? Map.of()
                : Collections.unmodifiableMap(new LinkedHashMap<>(attributes));
        occurredAt = Objects.requireNonNullElseGet(occurredAt, Instant::now);
    }

    public static NotificationMessage of(String recipient, String subject, String body) {
        return new NotificationMessage(recipient, subject, body, NotificationPriority.NORMAL, Map.of(), Instant.now());
    }

    public NotificationMessage withAttribute(String key, String value) {
        Map<String, String> next = new LinkedHashMap<>(attributes);
        next.put(requireText(key, "key"), requireText(value, "value"));
        return new NotificationMessage(recipient, subject, body, priority, next, occurredAt);
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value;
    }
}
