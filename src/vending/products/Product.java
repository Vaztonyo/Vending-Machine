package vending.products;

public class Product {
    String brand;
    String type;

    Product(String brand, String type){
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }
}
