# Implementation Guide

## 기본 사용

`NotificationChannel`을 구현하고 `NotificationDispatchers.composite(...)`로 dispatcher를 구성한다.

```java
NotificationChannel channel = new InMemoryNotificationChannel("memory");
NotificationDispatcher dispatcher = NotificationDispatchers.composite(List.of(channel));

NotificationDispatchResult result = dispatcher.dispatch(
        NotificationMessage.of("user-1", "Subject", "Body")
);
```

## 구현 규칙

- 채널 이름은 비어 있지 않아야 한다.
- 메시지는 `NotificationMessage`로 전달한다.
- 실패는 `NotificationDelivery.failed(...)`로 표현한다.
- dispatcher는 각 채널의 실패를 전체 예외로 전파하지 않고 전달 결과에 기록한다.
