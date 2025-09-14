package org.oops.SOLID.openClosePrinciple.violated;

import java.util.ArrayList;
import java.util.List;

class ProductImpl {
    private String name;
    private int price;

    ProductImpl(String name, int price) {
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

class ShoppingCartImpl {
    private final List<ProductImpl> products;

    public ShoppingCartImpl() {
        this.products = new ArrayList<>();
    }

    public List<ProductImpl> getProducts() {
        return products;
    }

    public void addProduct(ProductImpl p) {
        products.add(p);
    }

    //1. Calculate all the prices in the cart
    double calculateTotal() {
        double total = 0;
        for(ProductImpl product: products) {
            total+=product.getPrice();
        }
        return total;
    }
}

class PrintInvoice {
    private ShoppingCartImpl shoppingCart;

    public PrintInvoice(ShoppingCartImpl shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    //2. Print Invoice
    void printInvoice() {
        System.out.println("Print Invoice");
    }

}

class SaveToDB {
    private ShoppingCartImpl shoppingCart;

    public SaveToDB(ShoppingCartImpl shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    //3. Save to DB
    void saveToDb() {
        System.out.println("Save To DB");
    }
}

public class OCP_Violated {
    public static void main(String[] args) {
        ShoppingCartImpl cart = new ShoppingCartImpl();
        cart.addProduct(new ProductImpl("Books", 400));
        cart.addProduct(new ProductImpl("Notes", 200));
        System.out.println("Prices: "+cart.calculateTotal());

        PrintInvoice printInvoice = new PrintInvoice(cart);
        printInvoice.printInvoice();

        SaveToDB saveToDB = new SaveToDB(cart);
        saveToDB.saveToDb();
    }
}
