# Architecture

`notification`은 공통 계약, dispatcher, 채널 어댑터를 분리한다.

## 레이어

- `api`: 호출자와의 계약
- `core`: 도메인, dispatcher, sender
- `config`: Spring Boot 자동 구성
- `starter`: Spring Boot 의존성 진입점

## 원칙

- 메시지 계약은 프레임워크와 분리한다.
- sender는 전송 책임만 가진다.
- Spring은 선택적 어댑터다.
- 배포 가능한 모듈과 테스트용 모듈은 분리한다.

## 현재 구현

- `ConsoleNotificationSender`: 표준 출력 sender
- `WebhookNotificationSender`: HTTP webhook sender
- `EmailNotificationSender`: SMTP 이메일 sender
- `SlackWebhookNotificationSender`: Slack webhook sender
- `SenderRegistry`: sender 조합
- `DefaultNotificationService`: route + dispatch
