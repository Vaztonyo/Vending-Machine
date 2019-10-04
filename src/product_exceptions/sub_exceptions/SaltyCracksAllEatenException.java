package product_exceptions.sub_exceptions;

import product_exceptions.ProductNotFoundException;

public class SaltyCracksAllEatenException extends ProductNotFoundException {
    public SaltyCracksAllEatenException(String errMsg) {
        super(errMsg);
    }
}
