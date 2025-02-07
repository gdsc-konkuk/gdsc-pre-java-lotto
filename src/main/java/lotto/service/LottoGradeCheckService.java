package lotto.service;

import lotto.domain.product.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * <h4>로또 등수 계산</h4>
 */
public class LottoGradeCheckService {

    public List<Integer> checkGrade(Lotto winningLotto, int winningBonusNumber, List<Lotto> lottos){
        // 3개 일치, 4개 일치, 5개 일치, 5개+보너스 일치, 6개 일치 순으로 저장할 것.
        List<Integer> gradeList = new ArrayList<>(Collections.nCopies(5, 0));
        for (Lotto lotto : lottos) {
            int grade=compareNumbers(winningLotto, winningBonusNumber, lotto);
            if(grade!=-1){
                gradeList.set(grade,gradeList.get(grade)+1);
            }
        }
        return gradeList;
    }
    private int compareNumbers(Lotto winningLotto, int winningBonusNumber, Lotto lotto){
        // 3개 일치-0, 4개 일치-1, 5개 일치-2, 5개+보너스 일치-3, 6개 일치-4 반환
        int correctCount = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.matchNumber(winningLotto.getNumbers().get(i))) {
                correctCount++;
            }
        }
        if (correctCount == 5) {
            return 2+lotto.matchBonusNumber(winningBonusNumber);
        } else if (correctCount > 2 && correctCount < 5) {
            return correctCount-3;
        } else if (correctCount == 6) {
            return 4;
        }return -1;
    }
}
