# Architecture

`notification`은 메시지 모델과 전달 채널 계약을 프레임워크와 분리한다.

## 원칙

- API 계약은 프레임워크와 독립적이어야 한다.
- core는 API 계약의 기본 조합 로직만 제공한다.
- dispatcher는 채널 호출과 결과 집계만 책임진다.
- 외부 시스템 전송은 별도 확장 모듈이나 애플리케이션 계층에서 구현한다.

## 구성

- `notification-api`: 메시지와 전달 인터페이스
- `notification-core`: dispatcher와 기본 채널 구현

## 계층 규칙

- `notification-api`에는 도메인 계약만 둔다.
- `notification-core`에는 순수 Java 구현만 둔다.
- Spring Boot auto-configuration, SMTP client, Slack webhook client, HTTP webhook client는 포함하지 않는다.
