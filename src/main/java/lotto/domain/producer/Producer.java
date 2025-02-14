package lotto.domain.producer;

import lotto.domain.product.Product;

import java.util.List;

public interface Producer {
    public List<Product> produceProducts(int productCount);
}
