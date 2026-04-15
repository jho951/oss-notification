# Troubleshooting

## Gradle property 누락

`build.gradle`은 `release_group`, `release_version`, `java_version`, `github_org`, `github_repo`를 필수로 사용한다.

## Maven Central 인증 실패

릴리스 publish에는 다음 secret이 필요하다.

- `MAVEN_CENTRAL_USERNAME`
- `MAVEN_CENTRAL_PASSWORD`
- `MAVEN_CENTRAL_GPG_PRIVATE_KEY`
- `MAVEN_CENTRAL_GPG_PASSPHRASE`

## 채널이 호출되지 않음

`CompositeNotificationDispatcher`에 전달한 channel collection이 비어 있는지 확인한다.
