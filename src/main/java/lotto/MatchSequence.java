package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchSequence {

    private Lotto prizeNum;
    private int bonus;
    private List<Lotto> buy;
    private List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));//3,4,5,6,5+bonus

    public MatchSequence(Lotto prizeNum, int bonus, List<Lotto> buy) {
        this.prizeNum = prizeNum;
        this.bonus = bonus;
        this.buy = buy;
    }

    public void Matching() {
        for (Lotto lotto : buy) {
            MatchCalculator(lotto);
        }
    }

    private void MatchCalculator(Lotto lt) {
        int correctCount = 0;
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < prizeNum.getNumbers().size(); j++) {
                if(prizeNum.getNumbers().get(i)==lt.getNumbers().get(j)){
                    correctCount++;
                }
            }
        }
        if(correctCount==5){
            MatchBonusCalculator(lt);
        }else if (correctCount > 2) {
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