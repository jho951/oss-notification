package io.github.jho951.notification.api;

public interface NotificationDispatcher {
    NotificationDispatchResult dispatch(NotificationMessage message);
}
