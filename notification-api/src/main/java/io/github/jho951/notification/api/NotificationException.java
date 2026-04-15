package io.github.jho951.notification.api;

public class NotificationException extends RuntimeException {
    private final NotificationErrorCode errorCode;
    private final String channel;

    public NotificationException(NotificationErrorCode errorCode, String channel, String message) {
        super(message);
        this.errorCode = errorCode == null ? NotificationErrorCode.TRANSPORT_ERROR : errorCode;
        this.channel = channel == null || channel.isBlank() ? "unknown" : channel;
    }

    public NotificationException(NotificationErrorCode errorCode, String channel, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode == null ? NotificationErrorCode.TRANSPORT_ERROR : errorCode;
        this.channel = channel == null || channel.isBlank() ? "unknown" : channel;
    }

    public NotificationErrorCode errorCode() {
        return errorCode;
    }

    public String channel() {
        return channel;
    }
}
