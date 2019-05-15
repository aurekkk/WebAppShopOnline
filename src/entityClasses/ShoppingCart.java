package entityClasses;

import java.util.ArrayList;

public class ShoppingCart {

    public ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product product){
        this.items.add(product);
    }

    public ArrayList<Product> getCart(){
        return this.items;
    }

    public void copyItems(ArrayList<Product> items){
        this.items = items;
    }

}
