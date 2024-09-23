package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class User {
    private final List<Lotto> lottos;

    public User(Integer buyAmount) {
        Integer lottoCounts = buyAmount / 1000;
        this.lottos = this.makeLottos(lottoCounts);
        System.out.println(lottoCounts + "개를 구매했습니다.");
        System.out.println(this);
    }

    private List<Lotto> makeLottos(Integer lottoCounts) {
        List<Lotto> ret = new ArrayList<>();
        for (int i = 0; i < lottoCounts; i++) {
            ret.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList()));
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Lotto item : this.lottos) {
            ret.append(item.toString());
            ret.append("\n");
        }
        return ret.toString();
    }

    public String getResultString(Lotto winLotto, Integer bonus) {
        // 1. initialize
        StringBuilder ret = new StringBuilder();
        int totalEarnings = 0;
        int cost = this.lottos.size() * 1000;
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for(Rank rank: Rank.values()){
            rankCount.put(rank, 0);
        }
        // 2. calculate and build string
        totalEarnings = calRanks(winLotto, bonus, rankCount, totalEarnings);
        getStatisticsString(ret, rankCount);
        calculateProfitRate((double) totalEarnings, cost, ret);
        return ret.toString();
    }

    private int calRanks(Lotto winLotto, Integer bonus, Map<Rank, Integer> rankCount, int totalEarnings) {
        for(Lotto lotto: this.lottos){
            Long matches = lotto.countDup(winLotto);
            boolean bonusMatches = lotto.isBonus(bonus);
            Rank rank = Rank.getRank(matches, bonusMatches);
            rankCount.put(rank, rankCount.get(rank)+1);
            totalEarnings += rank.getPrizeMoney();
        }
        return totalEarnings;
    }

    private static void getStatisticsString(StringBuilder ret, Map<Rank, Integer> rankCount) {
        for(Rank rank: Rank.values()) {
            if(rank.getDescription().equals("꽝")){
                continue;
            }
            ret.append(rank.getDescription())
                .append(" - ")
                .append(rankCount.get(rank))
                .append("개\n");
        }
    }

    private static void calculateProfitRate(double totalEarnings, int cost, StringBuilder ret) {
        double profitRate = (totalEarnings / cost) * 100;
        ret.append("총 수익률은 ")
                .append(String.format("%.1f", profitRate))
                .append("%입니다.\n");
    }
}
