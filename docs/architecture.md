# Architecture

`notification`은 공통 계약과 채널 실행을 분리한다.

## 계층

- `api`: 호출자와의 계약
- `core`: 도메인, sender, 서비스
- `config`: Spring Boot 자동 구성
- `starter`: Spring Boot 의존성 진입점

## 원칙

- 메시지 계약은 프레임워크와 분리한다.
- sender는 전송 책임만 가진다.
- Spring은 선택적 어댑터다.
- 배포 가능한 모듈과 테스트용 모듈은 분리한다.

## 현재 구현

- `console`: 표준 출력 sender
- `webhook`: HTTP webhook sender
- `SenderRegistry`: sender 조합
- `DefaultNotificationService`: route + dispatch
