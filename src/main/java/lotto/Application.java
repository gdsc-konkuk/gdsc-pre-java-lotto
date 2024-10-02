package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputSequence is =new InputSequence(new Scanner(System.in),new Validation());
        is.PurchaseSequence();
        is.PrizeSequence();
        is.BonusSequence();

        MatchSequence ms=new MatchSequence(is.getPrizeNum(),is.getBonus(),is.getBuy());
        ms.Matching();

        PrintSequence ps=new PrintSequence(ms.getResult(),ms.getBuy());
        ps.Calculate();
        ps.ResultPrint();
    }
}
