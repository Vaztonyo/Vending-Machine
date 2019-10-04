package product_exceptions.sub_exceptions;

import product_exceptions.ProductNotFoundException;

public class ChocolatesAllGone extends ProductNotFoundException {
    public ChocolatesAllGone(String errMsg) {
        super(errMsg);
    }
}
