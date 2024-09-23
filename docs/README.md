# GDSC-pre-java-lotto
이름: 박범식

GitHub ID: SIKU-KR

### 구현할 클래스와 기능
1. <code>Application</code>: 프로그램의 실행 흐름과 UI 구현
   1. <code>getInputAmount()</code>: 얼마나 살건지 입력받는 함수
   2. <code>getInputWinningNumbers()</code>: 당첨번호를 입력받아 Lotto 객체를 반환
   3. <code>getInputBonusNumber()</code>: 보너스 번호를 입력받는다


2. <code>User</code>: 사용자 생성 및 정보 저장 목적의 객체
   1. <code>makeLottos()</code>: 사용자가 구입한 개수만큼의 로또 리스트를 생성하는 함수
   2. <code>makeLotto()</code>: 구입 단계에서 Lotto 번호 6개짜리 List를 생성하는 함수
   3. <code>getRandomNum()</code>: 1~45까지의 번호를 반환하는 함수
   4. <code>countSameNumbers()</code>: 로또 객체 A,B를 전달받아 A를 기준으로 B와 몇개가 겹치는지 검사
   5. <code>calEarningRate()</code>: 수익률을 계산


3. <code>Lotto</code>: 로또의 정보 저장
   1. <code>toString</code>: 출력 정보 오버라이딩

