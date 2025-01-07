package lotto;

import lotto.Product.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LottoGradeCheck {
    private Lotto winningLotto;
    private int winningBonusNumber;
    private List<Integer> winNum;
    public LottoGradeCheck(Lotto winningLotto, int winningBonusNumber) {
        this.winningLotto = winningLotto;
        this.winningBonusNumber = winningBonusNumber;
        this.winNum = winningLotto.getNumbers();
    }
    public List<Integer> checkGrade(List<Lotto> lottos){
        // 3개 일치, 4개 일치, 5개 일치, 5개+보너스 일치, 6개 일치 순으로 저장할 것.
        List<Integer> gradeList = new ArrayList<>(Collections.nCopies(5, 0));
        for (Lotto lotto : lottos) {
            int grade=compareNumbers(lotto);
            if(grade!=-1){
                gradeList.set(grade,gradeList.get(grade)+1);
            }
        }
        return gradeList;
    }
    private int compareNumbers(Lotto lotto){
        // 3개 일치-0, 4개 일치-1, 5개 일치-2, 5개+보너스 일치-3, 6개 일치-4 반환
        int correctCount = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < this.winNum.size(); j++) {
                if (this.winNum.get(i) == lotto.getNumbers().get(j)) {
                    correctCount++;
                }
            }
        }
        if (correctCount == 5) {
            return 2+matchBonusNumber(lotto);
        } else if (correctCount > 2 && correctCount < 5) {
            return correctCount-3;
        } else if (correctCount == 6) {
            return 4;
        }return -1;
    }
    private int matchBonusNumber(Lotto lotto){
        // 보너스번호가 로또 내 존재하면 1 아니면 0 반환
        if(lotto.getNumbers().contains(this.winningBonusNumber))
            return 1;
        return 0;
    }
}
