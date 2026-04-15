# Contributing

## 개발 기준

- 이 저장소는 1계층 알림 OSS로 유지합니다.
- 서비스별 정책, framework integration, DB entity는 본체에 넣지 않습니다.
- 새 구현체는 `NotificationChannel` 계약을 기준으로 추가합니다.

## 로컬 검증

```bash
./gradlew clean build
```

## 문서

공개 API나 모듈 책임이 바뀌면 `README.md`와 `docs/` 문서를 함께 갱신합니다.
