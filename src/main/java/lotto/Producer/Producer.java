package lotto.Producer;

import lotto.Product.Product;

import java.util.List;

public interface Producer {
    public List<Product> produceProducts(int productCount);
}
