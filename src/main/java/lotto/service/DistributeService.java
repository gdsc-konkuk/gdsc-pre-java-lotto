package lotto.service;

import lotto.domain.Seller;
import lotto.domain.product.Lotto;
import lotto.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * <h4>전반적인 물건 생성 판매 담당</h4>
 */
public class DistributeService {
    private final Seller seller;

    public DistributeService(Seller seller) {
        this.seller = seller;
    }
    // seller에게 count만큼의 Product에 대해 구매해서 결과 반환
    public List<Product> orderToSeller(int count){
        return seller.orderSequence(count);
    }
}
