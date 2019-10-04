# An exceptional VendingMachine

Loyolo is running a local spaza shop, he is building a vending machine that he wants to install at a friends BraaiShop.

He wants you to write him some software for this vending machine project of his.

Write a Java class called `VendingMachine` that has a `buy` method that takes in an instance of a `Product` class. Buying a product decrease the number of products in stock. In a product is out of stock an exception needs to be thrown.

There are three products:

* SoftDrinks
* SaltySnacks
* Chocolates

Create a class for each product, each of these products is a sub class of `Product`. Class names should not be plural. Each class can have a `description`.

The `VendingMachine` should keep track of the number of each product type it has in stock. An `addStock` method adds stock for a given product type. It's method signature is `addStock(Product product, int newStock)`

The `getStock` method return the Stock level for the Product type in question.

The `buy` method throws a `ProductNotFoundException` exception if the product is out of stock.

It should throw specific exceptions for each Product type - for all these `ProductNotFoundException` is there base class :

* `SoftDrinksOutOfStockException`
* `SaltyCracksAllEatenException`
* `ChocolatesAllGone`

It should throw an `InvalidProductException` if you try and `buy` a product other than ` SoftDrink, SaltySnack, Chocolates`. `InvalidProductException` is a RuntimeException.

Create a `main` method that takes your vending machine through it's paces
