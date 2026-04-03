package com.notification.core.senders;

import com.notification.core.ChannelId;
import com.notification.core.NotificationMessage;
import com.notification.core.NotificationRequest;
import com.notification.core.NotificationResult;
import com.notification.core.NotificationSender;
import com.notification.core.Recipient;
import org.junit.jupiter.api.Test;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WebhookNotificationSenderTest {
    @Test
    void postsPayloadToWebhook() throws Exception {
        AtomicReference<String> bodyRef = new AtomicReference<>();
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/hook", exchange -> handle(exchange, bodyRef));
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();

        try {
            URI uri = URI.create("http://127.0.0.1:" + server.getAddress().getPort() + "/hook");
            NotificationSender sender = new WebhookNotificationSender(uri.toString());

            NotificationResult result = sender.send(new NotificationRequest(
                    new ChannelId("webhook"),
                    new NotificationMessage("hello", "body"),
                    List.of(new Recipient("r1", "user@example.com")),
                    Map.of("source", "test")
            ));

            assertTrue(result.success());
            String body = bodyRef.get();
            assertTrue(body.contains("\"title\":\"hello\""));
            assertTrue(body.contains("\"body\":\"body\""));
            assertTrue(body.contains("\"recipientCount\":1"));
        } finally {
            server.stop(0);
        }
    }

    private void handle(HttpExchange exchange, AtomicReference<String> bodyRef) throws IOException {
        try (InputStream input = exchange.getRequestBody()) {
            bodyRef.set(new String(input.readAllBytes(), StandardCharsets.UTF_8));
        }
        exchange.sendResponseHeaders(200, 0);
        exchange.getResponseBody().close();
    }
}
