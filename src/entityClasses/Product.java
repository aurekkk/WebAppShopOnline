package entityClasses;

import com.mysql.cj.xdevapi.DbDoc;
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

    public String getCode() {
        return code;
    }

    public Product(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public Product() {
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



}
