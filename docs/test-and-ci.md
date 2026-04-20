# Testing And CI

## 로컬 테스트

```shell
./gradlew clean test
```

## 검증 범위

- `notification-api` 공개 모델 컴파일
- `notification-core` dispatcher 조합 동작
- reference channel 전달 결과

## CI

- pull request와 `main` push에서 `./gradlew clean test --no-daemon --stacktrace`를 실행한다.
- 릴리스 태그에서는 테스트 후 Maven Central publish를 실행한다.
