package io.github.jho951.notification.api;

public enum NotificationErrorCode {
    NONE,
    NO_CHANNELS,
    INVALID_MESSAGE,
    INVALID_CONFIGURATION,
    TRANSPORT_ERROR,
    TIMEOUT,
    UNSUPPORTED_TARGET,
    IO_ERROR
}
