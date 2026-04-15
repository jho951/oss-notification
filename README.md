# notification

`notification`은 알림 메시지와 전달 채널을 위한 순수 1계층 OSS 추상화다.

## 책임

- 알림 메시지 모델 정의
- 알림 전달 인터페이스 제공
- 여러 전달 채널의 조합
- 프레임워크 독립적인 기본 구현 제공

## 기준

- 공통 계약과 경계 규칙은 [oss-contract](https://github.com/jho951/oss-contract)를 따른다.

## 모듈

- `notification-api`
- `notification-core`

## 제외 범위

- 인증
- 정책 평가
- 감사 저장
- 파일 저장
- Spring 자동 구성
- 외부 전송 어댑터
- 서비스 비즈니스 로직

## 버전 정책

- 기본 버전 SOT는 `gradle.properties`의 `release_version`이다.
- 릴리스 태그 push 시 `release_version`이 주입되어 Maven Central에 publish한다.

## 문서

1. [docs/README.md](docs/README.md)
2. [docs/architecture.md](docs/architecture.md)
3. [docs/modules.md](docs/modules.md)
4. [docs/implementation-guide.md](docs/implementation-guide.md)
5. [docs/extension-guide.md](docs/extension-guide.md)
6. [docs/testing-and-ci.md](docs/testing-and-ci.md)
7. [docs/troubleshooting.md](docs/troubleshooting.md)
