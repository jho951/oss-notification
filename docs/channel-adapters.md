# Channel Adapters

`notification`은 sender를 채널별 어댑터로 본다.

## 포함 채널

- `console`
- `webhook`
- `email`
- `slack`

## 원칙

- 어댑터는 메시지 계약을 변경하지 않는다.
- 어댑터는 전송 방식만 책임진다.
- 인증과 정책은 상위 계층 책임이다.

## 채널별 용도

| Channel | 용도 |
| --- | --- |
| `console` | 로컬 출력, 디버깅 |
| `webhook` | 범용 HTTP webhook |
| `email` | SMTP 이메일 발송 |
| `slack` | Slack 알림 발송 |

## 확장 기준

- 외부 벤더용 webhook adapter

## 제외

- 큐
- 저장소
- 스케줄링
