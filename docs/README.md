# 🚀 기능 명세서

- [ ] 로또 구입 금액 - Money
  - [ ] "구입금액을 입력해주세요." 출력 - InputView#inputMoney
  - [ ] 구입 금액 입력
    - [ ] 1000 단위로 나누어 떨어지지 않는 경우 Money#validate
    - [ ] 0원 이하 입력한 경우 Money#validate
- [ ] 로또 발행 - Lotto & Lottos
  - [ ] 입력 받은 금액만큼 발행 Lotto#publishLottoByMoney
    - [ ] "n개를 구매했습니다." 출력 - OutputView#printLottosCount
    - [ ] "[i, j, k]" 리스트 형식으로 출력 - OutputView#printLottos
  - [ ] 1~45 중복되지 않는 6개 숫자 - RandomNumberGenerator#create6RandomNumbers
      - `List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);` 라이브러리 사용
- [ ] 당첨 번호 입력 - WinningNumbers#Lotto
  - "당첨 번호를 입력해 주세요." 출력 - InputView#inputWinningLotto
  - 당첨 번호 입력 : 쉼표 구분
    - [ ] 1~45 중복되지 않는 6개 숫자
- [ ] 보너스 번호 입력 - WinningNumbers#bonus
  - [ ] "보너스 번호를 입력해 주세요." 출력 - InputView#inputWinningBonus
    - [ ] 1~45 사이 1개 숫자
- [ ] 당첨 내역 - WinningResult
  - [ ] 당첨 결과 목록 - WinningEnum
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
  - [ ] 당첨 내역 출력 
      - [ ] "당첨 통계\n---" 출력 - OutputView#printWinningStats
        - [ ] n개 일치 (n,000원) - n개 - OutputView#printWinningResult
- [ ] 수익률 계산 - Calculator#calculateEarningRate
  - [ ] "총 수익률은 00.0%입니다." 출력 - OutputView#printEarningRates
  - [ ] 소수점 둘째 자리에서 반올림
  - [ ] 구입 금액 대비 상금액

# ✔리팩터링 todo