<img src="https://skillicons.dev/icons?i=java,spring">

> **객체지향의 사실과 오해** 라는 책을 읽고, 아예 새로 짜보기로 하였다. 또한 소프트웨어공학 수업에서 배운 다이어그램들과 기법들이 구현에 용이한지 직접 확인해보고자 하였다.
### 프로그램 요구사항(흐름) 정리
로또 구입 금액 입력**→**당첨 번호 입력**→**보너스 번호 입력**→**로또 수량 및 번호 출력**→**당첨 내역 출력**→**수익률 출력

### 주요 메세지 정의
어떤 메세지를 주고받을 것인가, 이것을 가장 먼저 정해야 한다.
문제에서의 가장 중요한 행동은 다음과 같다.
- 로또 구입
- 당첨 번호와 보너스 번호 전달
- 당첨 확인
- 수익률 계산
### 세부 메세지 정의
a. 로또 구입 - 로또 구입 금액 입력받음(+오류 출력), 금액에 맞는 갯수의 로또 구매
b. 당첨 번호와 보너스 번호 전달 - 당첨 번호와 보너스 번호 입력받음, 로또 당첨 확인하는 것에 이 번호들 전달
c. 당첨 확인 - 구입한 로또와 당첨/보너스 번호 바탕으로 당첨 확인, 결과(등수) 전달
d. 수익률 계산 - 등수와 상금을 기준으로 수익률 계산

---
### Communication Diagram
<img width="809" alt="Communication Diagram" src="https://github.com/user-attachments/assets/64ef8c53-6328-4e7c-a979-22659817cae1" />

---

>현 프로그램에서는, 유저가 한명 뿐이고 실행과 동시에 구매를 진행하게 된다. 

**따라서, 시작과 동시에** 다음 순서로 프로그램이 진행되게 된다
1. Purchase Lotto
2. Request New Lotto
3. Setting Winning Number
4. Check Lotto Grade
5. Calculate Prize
6. Calculate Rate of Profit

---
### Class Diagram
JAVA의 네이밍 규칙을 신경써보기로 했다.
1. 변수 이름이나 메서드 이름은 **camelCase**를 사용
2. 클래스 이름이나 인터페이스 이름은 **PascalCase**를 사용
<img width="851" alt="Class Diagram" src="https://github.com/user-attachments/assets/24a04343-1713-4cfd-b7ba-510026131322" />
입력하는 로또 번호의 유효성 체크는 validate에서 진행된다. 다른 입력에 대한 유효성 체크는 IOSequence에서 진행된다