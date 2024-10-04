package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    Validation vd = Application.vd;

    public Lotto(List<Integer> numbers) {
        String s = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        this.numbers = validate(s);
    }

    public Lotto(String s) {
        this.numbers = validate(s);
    }

    private List<Integer> validate(String s) {
        return vd.prizeValid(s);
    }

    public Lotto() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(numbers);
    }

    public void Match(List<Lotto> lottoList, int bonus) {
        for (Lotto lotto : lottoList) {
            Match(lotto, bonus);
        }
    }

    public void Match(Lotto lotto, int bonus) {
        int correctCount = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < this.numbers.size(); j++) {
                if (this.numbers.get(i) == lotto.getNumbers().get(j)) {
                    correctCount++;
                }
            }
        }
        if (correctCount == 5) {
            MatchBonusNumber(lotto, bonus);
        } else if (correctCount > 2 && correctCount < 5) {
            LottoRank.valueOfRank(8 - correctCount).incrementCount();
        } else if (correctCount == 6) {
            LottoRank.valueOfRank(1).incrementCount();
        }
    }

    private void MatchBonusNumber(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            LottoRank.valueOfRank(2).incrementCount();
            return;
        } LottoRank.valueOfRank(3).incrementCount();

    }

    public void printField() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
