package lotto;

import lotto.Producer.Producer;
import lotto.Product.Lotto;
import lotto.Product.Product;

import java.util.List;

public class Seller {
    private Producer producer;

    public Seller(Producer Producer) {
        this.producer = Producer;
    }

    public List<Product> orderSequence(int ProductCount, User Buyer) {
        // producer 에게서 상품을 만들어 Buyer 에게 전달
        return this.producer.produceProducts(ProductCount);
    }

}
