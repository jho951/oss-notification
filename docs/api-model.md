# API Model

## 현재 계약

- `NotificationClient`
- `SendNotificationCommand`
- `SendNotificationResponse`

## 원칙

- command는 호출 의도를 표현한다.
- response는 성공과 실패를 구분한다.
- 내부 sender 구현은 공개 계약에 노출하지 않는다.

## 개선 여지

- 타입 안전한 command builder
- 실패 코드 표준화
- recipient 타입 분리
