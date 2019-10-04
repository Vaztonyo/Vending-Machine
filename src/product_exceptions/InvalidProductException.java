package product_exceptions;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException(String errMsg){
        super(errMsg);
    }
}
