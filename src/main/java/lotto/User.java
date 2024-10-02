package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

/*
* User Class
* 로또를 구입한 사용자를 추상화한 객체
* 1. 구입 금액을 가지고 새로운 User 객체를 반환합니다 이때 문제에서 제시된 함수로 Lotto의 List를 만듭니다.
* 2. getResult 함수를 통해 User의 수익률을 분석하고, 이를 String으로 빌드하여 반환합니다.
* */
public class User {
    private final List<Lotto> lottos;

    public User(Integer buyAmount) {
        Integer lottoCounts = buyAmount / 1000;
        IO.printLottoCounts(lottoCounts);
        this.lottos = this.makeLottos(lottoCounts);
    }

    private List<Lotto> makeLottos(Integer lottoCounts) {
        List<Lotto> ret = new ArrayList<>();
        for (int i = 0; i < lottoCounts; i++) {
            ret.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().toList()));
        }
        return ret;
    }


    public String getResult(Lotto winLotto, Integer bonus) {
        int cost = this.lottos.size() * 1000;
        Map<Rank, Integer> rankCount = getRankCounts(winLotto, bonus);
        int totalEarnings = getTotalEarnings(rankCount);
        double profitRate = ((double) totalEarnings / cost) * 100;
        return getResultString(rankCount, profitRate);
    }



    private int getTotalEarnings(Map<Rank, Integer> rankCount) {
        int totalEarnings = 0;
        for (Rank rank : Rank.values()) {
            totalEarnings += rank.getPrizeMoney() * rankCount.get(rank);
        }
        return totalEarnings;
    }


    private Map<Rank, Integer> getRankCounts(Lotto winLotto, Integer bonus) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for(Rank rank: Rank.values()){
            rankCount.put(rank, 0);
        }
        for(Lotto lotto: this.lottos){
            Long matches = lotto.countDup(winLotto);
            boolean isBonusMatches = lotto.isBonus(bonus);
            Rank rank = Rank.getRank(matches, isBonusMatches);
            rankCount.put(rank, rankCount.get(rank)+1);
        }
        return rankCount;
    }

    private String getResultString(Map<Rank, Integer> rankCount, double profitRate){
        StringBuilder ret = new StringBuilder();
        for(Rank rank: Rank.values()) {
            if(rank.getDescription().equals("꽝")){
                continue;
            }
            ret.append(rank.getDescription())
                    .append(" - ")
                    .append(rankCount.get(rank))
                    .append("개\n");
        }
        ret.append("총 수익률은 ")
                .append(String.format("%.1f", profitRate))
                .append("%입니다.\n");
        return ret.toString();
    }
}
