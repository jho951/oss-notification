# CONTRACT_SYNC - notification

## 기준

- 기준 SOT: `oss-contract`
- 대상 레포: `notification`

## 버전 규칙

- 기본 버전 SOT는 `gradle.properties`의 `release_version`이다.
- 릴리스 시에만 `release_version`을 태그 버전으로 override한다.
- `build.gradle`의 하드코딩 fallback은 두지 않는다.

## 확인된 역할

- 일반 알림 추상화 OSS
- 메시지 발행 / 전달 인터페이스 제공
- dispatcher와 in-memory channel 제공
- 프레임워크 독립적인 순수 1계층 모듈

## 반영 문서

- `README.md`
- `docs/README.md`
- `docs/architecture.md`
- `docs/modules.md`
- `docs/implementation-guide.md`
- `docs/extension-guide.md`
- `docs/testing-and-ci.md`
- `docs/troubleshooting.md`
- `gradle.properties`
- `build.gradle`
- `settings.gradle`
- `.github/workflows/build.yml`
- `.github/workflows/publish.yml`
