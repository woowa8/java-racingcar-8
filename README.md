# java-racingcar-precourse - 구현 기능 정리

## View
### InputView
- [x] 차 이름 입력 받는 기능
- [x] 시도 횟수 입력 받는 기능
- 예외 처리
    - [x] 시도 횟수가 숫자가 아니면 예외
    - [x] 시도 횟수가 음수거나 0이면 예외

### OutputView
- [x] 실행 결과 제목
- [x] 게임 실행 결과 자체를 계속 내보내는 기능
- [x] 최종 우승자 내보내는 기능

---

## Domain
### Car
- 기능 구현
    - [x] 차 이름, 현재 위치, mark를 가진다.
    - [x] 현재 위치를 더하는 기능
    - [x] getter
- 예외 처리
    - [x] 현재 위치가 - 일 수 없다.
    - [x] 이름은 다섯 자리 이하여야 한다.

---

## Util
### InputParser
- 기능 구현
    - [x] ,으로 이름을 나눠서 return
- 예외 처리
    - [x] 나눈 결과가 하나이면 혼자서 경주는 불가능하므로 예외처리

---

## Repository
### CarRepository
- 기능 구현
    - [x] 자동차 추가
    - [x] 특정 자동차 찾기 (이름으로)

---

## Service
### CarService
- 기능 구현
    - [x] 우승자 판별 로직 (pos가 가장 큰 사람들)
    - [x] 운전 로직 (car 도메인 내부의 add)
    - [x] 랜덤 번호 생성 로직
- 예외 처리
    - [x] 차를 저장할때, 이미 있는 이름이면 다른 이름을 입력 받아야 한다.

---

## Controller
### CarController
- 기능 구현
    - [x] inputView와 outputView와 소통한다.
    - [x] 한 턴한턴 결과를 outputView로 내보낸다.
- 예외 처리
    - [x] try - catch로 받아서 다시 예외 던진다. (요구사항 맞춤)
