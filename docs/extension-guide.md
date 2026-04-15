# Extension Guide

## 추가 가능

- 새로운 전달 채널 구현
- 새로운 dispatcher 조합 전략
- 새로운 메시지 attribute 규칙
- 새로운 알림 우선순위

## 추가 위치

- 공통 계약 변경은 `notification-api`에 둔다.
- 기본 구현 또는 reference 구현은 `notification-core`에 둔다.
- 특정 프레임워크나 외부 서비스 연동은 별도 모듈 또는 애플리케이션에서 구현한다.

## 추가 불가

- 인증 책임
- 정책 엔진 책임
- 감사 저장 책임
- 파일 저장 책임
- Spring 자동 구성
- SMTP / Slack / webhook 전송 책임
- 서비스 비즈니스 규칙
