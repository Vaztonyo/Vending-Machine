package product_exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String errMsg){
        super(errMsg);
    }

}
