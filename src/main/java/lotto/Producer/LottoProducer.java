package lotto.Producer;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Product.Lotto;
import lotto.Product.Product;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoProducer implements Producer {
    @Override
    public List<Product> produceProducts(int productCount) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productCount; i++) {
            products.add(produceLotto());
        }
        return products;
    }
    private Product produceLotto(){
        List<Integer> numbers = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Integer::compareTo);
        return new Lotto(numbers);
    }
}
