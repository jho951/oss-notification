package com.notification.core;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultNotificationServiceTest {
    @Test
    void routesToRegisteredSender() {
        AtomicReference<NotificationRequest> seen = new AtomicReference<>();
        NotificationSender sender = new NotificationSender() {
            private final ChannelId channelId = new ChannelId("console");

            @Override
            public ChannelId channelId() {
                return channelId;
            }

            @Override
            public NotificationResult send(NotificationRequest request) {
                seen.set(request);
                return NotificationResult.success("ok-1");
            }
        };

        NotificationService service = new DefaultNotificationService(new SenderRegistry(List.of(sender)));
        NotificationResult result = service.send(
                new ChannelId("console"),
                new NotificationMessage("hello", "body"),
                List.of(new Recipient("r1", "user@example.com")),
                Map.of("source", "test")
        );

        assertTrue(result.success());
        assertEquals("ok-1", result.providerMessageId());
        assertEquals(new ChannelId("console"), seen.get().channelId());
        assertEquals("hello", seen.get().message().title());
        assertEquals("body", seen.get().message().body());
        assertEquals(1, seen.get().recipients().size());
        assertEquals("user@example.com", seen.get().recipients().get(0).address());
    }
}
