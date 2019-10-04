package product_exceptions.sub_exceptions;

import product_exceptions.ProductNotFoundException;

public class SoftDrinksOutOfStockException extends ProductNotFoundException {
    public SoftDrinksOutOfStockException(String errMsg) {
        super(errMsg);
    }
}
