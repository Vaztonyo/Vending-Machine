package vending;

import product_exceptions.*;
import product_exceptions.sub_exceptions.*;
import vending.products.*;

import java.util.*;

public class VendingMachine {

    public Map<String, Integer> stock = new HashMap<>();

    public void add(Product product, int newStock) {
        boolean condition1 = product.getType().equals("SoftDrink") || product.getType().equals("SaltySnack") || product.getType().equals("Chocolate");

        if (!condition1){
            throw new InvalidProductException("That product is not a valid product for this vending machine");
        } else {
            if (stock.containsKey(product.getType())){
                stock.computeIfPresent(product.getType(), (k,v)-> v += newStock);
            } else {
                stock.put(product.getType(), newStock);
            }
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
            throw new ProductNotFoundException("No Products in Vending Machine");
        }

        return message;
    }

    public String getStock(Product product) throws ProductNotFoundException {
        String message = "";
        if (stock.containsKey(product.getType())){
            message = product.getType() + " available stock: " + stock.get(product.getType());
        }  else {
            throw new ProductNotFoundException("No Products in Vending Machine");
        }
        return message;
    }

    public void buy(Product product) throws ProductNotFoundException, InvalidProductException {
        boolean condition1 = product.getType().equals("SoftDrink") || product.getType().equals("SaltySnack") || product.getType().equals("Chocolate");

        if (!condition1){
            throw new InvalidProductException("Invalid Product");
        } else {
            if (product.getType().equals("SoftDrink") && !stock.containsKey(product.getType())){
                throw new SoftDrinksOutOfStockException("No Soft Drinks In Vending Machine");
            } else if (product.getType().equals("SaltySnack") && !stock.containsKey(product.getType())){
                throw new SaltyCracksAllEatenException("No More Salty Snacks In Vending Machine");
            }
            else if (product.getType().equals("Chocolate") && !stock.containsKey(product.getType())){
                throw new ChocolatesAllGone("No Chocolates Left In Vending Machine");
            }
            else {
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

    public static void main(String[] args) {
        Product soft = new SoftDrink("Fanta");
        Product soft1 = new SoftDrink("Coke");
        VendingMachine ven = new VendingMachine();

        ven.add(soft, 5);
        ven.add(soft1, 2);

        try {
            System.out.println(ven.getStock());
            ven.buy(soft1);
            System.out.println(ven.getStock(soft1));
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }


    }
}
