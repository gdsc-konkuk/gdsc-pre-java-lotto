package lotto.controller;

import lotto.Exception.Validation;
import lotto.Model.Lotto;
import lotto.Model.User;
import lotto.view.In;
import lotto.view.Out;

import java.util.Arrays;
import java.util.List;

/*
 * Controller Class
 * View 패키지의 in과 out에 대해 의존관계를 가짐
 * 1. 프로그램의 흐름 관리 (run 함수)
 * */
public class Controller {
    private In inview;
    private Out outview;

    public Controller(In inview, Out outview) {
        this.inview = inview;
        this.outview = outview;
    }

    public void run(){
        User user = makeUser();
        Lotto winLotto = makeWinLotto();
        Integer bonusNum = getBonusNumber(winLotto);
        outview.printResult(user.getResult(winLotto, bonusNum));
    }

    private User makeUser(){
        User user = new User(this.getAmount());
        List<Lotto> lottos = user.getLottos();
        outview.printLottoCounts(lottos.size());
        for (Lotto lotto: lottos){
            outview.printLotto(lotto);
        }
        return user;
    }

    private Integer getAmount(){
        try{
            Integer value = inview.getAmount();
            Validation.inputAmount(value);
            return value;
        } catch(NumberFormatException e){
            System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            return this.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.getAmount();
        }
    }

    private Lotto makeWinLotto(){
        Lotto winLotto = new Lotto(this.getWinLottoNumbers());
        outview.printLotto(winLotto);
        return winLotto;
    }

    private List<Integer> getWinLottoNumbers(){
        try{
            String value = inview.getWinLotto();
            List<Integer> parsedValue = this.parseInputForWinnings(value);
            Validation.lottoNumbers(parsedValue);
            return parsedValue;
        } catch(NumberFormatException e){
            System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            return this.getWinLottoNumbers();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return this.getWinLottoNumbers();
        }
    }

    public List<Integer> parseInputForWinnings(String str) throws NumberFormatException{
        return Arrays.stream(str.split(","))
                .map(s -> Integer.parseInt(s.trim())).toList();
    }

    public Integer getBonusNumber(Lotto winLotto){
        try{
            Integer value = inview.getBonus();
            Validation.lottoNumberRange(value);
            Validation.bonusNumber(winLotto, value);
            return value;
        } catch(NumberFormatException e){
            System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            return this.getBonusNumber(winLotto);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return this.getBonusNumber(winLotto);
        }
    }
}
