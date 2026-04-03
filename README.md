# notification

`notification`은 메시지 발송을 위한 독립 OSS 모듈입니다.

## 핵심 축

- `api`: 외부 계약
- `core`: 도메인, dispatcher, sender
- `config`: Spring Boot auto-configuration
- `starter`: Spring Boot 진입점

## 채널

| Channel | Purpose |
| --- | --- |
| `console` | 로컬 확인과 디버깅 |
| `webhook` | 범용 HTTP 연동 |
| `email` | SMTP 이메일 전송 |
| `slack` | Slack webhook 전송 |

## 빌드와 배포

- 테스트: `./gradlew test`
- 배포: `v*` tag push 시 GitHub Actions가 테스트 후 Maven Central에 publish

## 문서

1. [docs/README.md](docs/README.md)
2. [docs/architecture.md](docs/architecture.md)
3. [docs/modules.md](docs/modules.md)
4. [docs/delivery-model.md](docs/delivery-model.md)
5. [docs/channel-adapters.md](docs/channel-adapters.md)
6. [docs/api-model.md](docs/api-model.md)
