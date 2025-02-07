package lotto.domain;

import lotto.domain.producer.Producer;
import lotto.domain.product.Product;

import java.util.List;

public class Seller {
    private Producer producer;

    public Seller(Producer Producer) {
        this.producer = Producer;
    }

    public List<Product> orderSequence(int ProductCount) {
        // producer 에게서 상품을 만들어 Buyer 에게 전달
        return this.producer.produceProducts(ProductCount);
    }

}
