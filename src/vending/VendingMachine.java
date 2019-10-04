package vending;

import product_exceptions.InvalidProductException;
import product_exceptions.ProductNotFoundException;
import vending.products.Chocolate;
import vending.products.Product;
import vending.products.SoftDrink;

import java.util.*;

public class VendingMachine {

    public Map<String, Integer> stock = new HashMap<>();

    public void add(Product product, int newStock) {
        if (stock.containsKey(product.getType())){
            stock.computeIfPresent(product.getType(), (k,v)-> v += newStock);
        } else {
            stock.put(product.getType(), newStock);
        }
    }

    public String getStock() throws ProductNotFoundException{
        String value = "";
        String key = "";
        String message = "";

        if (!stock.isEmpty()){
            for (String type: stock.keySet()){
                key = type;
                value = stock.get(type).toString();
                message = "\nType: " + key + ", Stock available: " + value + "\n";
            }
        } else {
            throw new ProductNotFoundException();
        }

        return message;
    }

    public void getStock(Product product){

    }

    public void buy(Product product) throws ProductNotFoundException, InvalidProductException {
        boolean condition1 = product.getType().equals("SoftDrink") || product.getType().equals("SaltySnack") || product.getType().equals("Chocolate");

        if (!condition1){
            throw new InvalidProductException();
        } else {
            if (!stock.containsKey(product.getType())){
                throw new ProductNotFoundException();
            } else {
                for (Map.Entry<String, Integer> entry : stock.entrySet() ) {
                    if (entry.getValue() > 0){
                        stock.computeIfPresent(product.getType(), (k, v) -> v -= 1);
                    }
                    else {
                        stock.remove(entry.getKey());
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws ProductNotFoundException {
        Product soft = new SoftDrink("Fanta");
        VendingMachine ven = new VendingMachine();

        ven.stock.put("SoftDrink", 5);
        System.out.println(ven.getStock());
        ven.buy(soft);
        ven.buy(soft);
        ven.buy(soft);
        ven.buy(soft);
        ven.buy(soft);
        ven.buy(soft);
        System.out.println(ven.getStock());
        System.out.println(ven.getStock());

    }
}
