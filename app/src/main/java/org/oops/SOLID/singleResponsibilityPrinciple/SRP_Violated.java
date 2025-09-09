package org.oops.SOLID.singleResponsibilityPrinciple;
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class ShoppingCart {
    private final List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    //1. Calculate all the prices in the cart
    double calculateTotal() {
        double total = 0;
        for(Product product: products) {
           total+=product.getPrice();
        }
        return total;
    }

    //2. Print Invoice
    void printInvoice() {
        System.out.println("Print Invoice");
    }

    //3. Save to DB
    void saveToDb() {
        System.out.println("Save To DB");
    }

}

public class SRP_Violated {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Books", 400));
        cart.addProduct(new Product("Notes", 200));
        System.out.println("Prices: "+cart.calculateTotal());
        cart.printInvoice();
        cart.saveToDb();
    }
}
