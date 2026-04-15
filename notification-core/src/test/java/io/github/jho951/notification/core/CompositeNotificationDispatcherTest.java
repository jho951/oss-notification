package io.github.jho951.notification.core;

import io.github.jho951.notification.api.NotificationMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompositeNotificationDispatcherTest {
    @Test
    void dispatchesToAllChannels() {
        InMemoryNotificationChannel first = new InMemoryNotificationChannel("email");
        InMemoryNotificationChannel second = new InMemoryNotificationChannel("sms");
        CompositeNotificationDispatcher dispatcher = new CompositeNotificationDispatcher(List.of(first, second));

        NotificationMessage message = NotificationMessage.of("user-1", "Subject", "Body");
        var result = dispatcher.dispatch(message);

        assertTrue(result.delivered());
        assertEquals(2, result.deliveries().size());
        assertEquals(1, first.messages().size());
        assertEquals(1, second.messages().size());
    }
}
