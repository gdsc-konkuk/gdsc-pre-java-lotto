package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchSequence {

    private List<Integer> prizeNum;
    private int bonus;
    private List<Lotto> buy;
    private List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));//3,4,5,6,5+bonus

    public MatchSequence(List<Integer> prizeNum, int bonus, List<Lotto> buy) {
        this.prizeNum = prizeNum;
        this.bonus = bonus;
        this.buy = buy;
    }

    public void Matching() {
        Collections.sort(prizeNum);
        for (Lotto lotto : buy) {
            Collections.sort(lotto.getNumbers());
            MatchCalculator(lotto);
        }
    }

    private void MatchCalculator(Lotto lt) {
        int prizeindex = 0, buyindex = 0, correctCount = 0;
        while (prizeindex < prizeNum.size() && buyindex < lt.getNumbers().size()) {
            if (prizeNum.get(prizeindex).equals(lt.getNumbers().get(buyindex))) {
                correctCount++;
                prizeindex++;
                buyindex++;
            } else if (prizeNum.get(prizeindex) < lt.getNumbers().get(buyindex)) prizeindex++;
            else if(prizeNum.get(prizeindex) > lt.getNumbers().get(buyindex)) buyindex++;
        }
        if (correctCount == 5) {
            MatchBonusCalculator(lt);
        } else if (correctCount > 2) {
            result.set(correctCount - 3, result.get(correctCount - 3) + 1);
        }
    }

    private void MatchBonusCalculator(Lotto lt) {
        if (lt.getNumbers().contains(bonus)) {
            result.set(4, result.get(4) + 1);
        } else {
            result.set(2, result.get(2) + 1);
        }
    }

    public List<Lotto> getBuy() {
        return buy;
    }

    public List<Integer> getResult() {
        return result;
    }
}