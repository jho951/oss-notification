# Modules

## 역할

- `notification-api`: 메시지 모델, 전달 결과, 채널/dispatcher 인터페이스
- `notification-core`: dispatcher 조합 구현과 기본 reference channel

## 의존 방향

- `notification-core`는 `notification-api`에만 의존한다.
- `notification-api`는 다른 모듈에 의존하지 않는다.
- Spring, SMTP, Slack, webhook 같은 외부 연동은 이 OSS 1계층 모듈에 포함하지 않는다.
