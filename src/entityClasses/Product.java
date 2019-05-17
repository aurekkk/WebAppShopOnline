package entityClasses;


import model.DBcon;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Product {

    String code;
    String name;
    double price;
    int quantity;
    int buyersquantity=1;

    public Product(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public Product() {
    }

    public void setBuyersquantity(int buyersquantity) {
        this.buyersquantity = buyersquantity;
    }

    public int getBuyersquantity() {
        return buyersquantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> listOfProduct(){

        DBcon dBcon = new DBcon();

        return dBcon.DBListOfProducts();

    }
    public Product productById(String code){
        DBcon dBcon = new DBcon();

        return dBcon.DBProductById(code);
    }

    public Product getProduct(){
        return this;
    }

    public void addProduct(String name, String price, String quantity){

        DBcon dBcon = new DBcon();

        dBcon.DBAddProduct(name, price, quantity);

    }

    public boolean removeProduct(String code){
        DBcon dBcon = new DBcon();
        return dBcon.DBRemoveProduct(code);
    }

    public boolean editProduct(String code, String name, String price, String quantity){
        DBcon dBcon = new DBcon();
        return dBcon.DBEditProduct(code, name, price, quantity);
    }

    public void modifyQuantity(Product p){
        DBcon dBcon = new DBcon();
        dBcon.DBModifyQuanitity(p);
    }

}
