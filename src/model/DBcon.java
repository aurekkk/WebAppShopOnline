package model;

import entityClasses.Product;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBcon {
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopdb?sslMode=DISABLED", "root", "cisco");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public boolean isValidLoginCredentials(String username, String password){

        boolean isValid = false;
        Connection connection = null;
        Statement statement = null;
        try{
            connection = getConnection();
            statement=connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where username = \"" + username +"\"" +
                    "and password = \"" + password + "\"");
            if (rs.next()){
                isValid = true;
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValid;

    }

    public String DBUserRole(String username){
        String role = "notfound";
        Connection connection = null;
        Statement statement = null;
        try {
            connection=getConnection();
            statement=connection.createStatement();
            statement.executeQuery("select role from users where username =\"" + username + "\"");
            ResultSet rs=statement.getResultSet();
            if(rs.next()){
                role=rs.getString("role");
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return role;
    }

    public int DBRegisterUser(String username, String password){
        int isRegistred = -1;
        Connection connection=null;
        PreparedStatement statement = null;
        try {
            connection=getConnection();
            statement= connection.prepareStatement("insert into users (username, password) values (?, ?)");
            statement.setString(1, username);
            statement.setString(2, password);
            isRegistred = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isRegistred;
    }

    public List<Product> DBListOfProducts(){
        List<Product> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from products");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                list.add(new Product(code, name, price ,quantity));
            }
            connection.close();
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public Product DBProductById(String id){
        Product product = null;
        Connection connection=null;
        PreparedStatement statement = null;
        try{
            connection=getConnection();
            statement=connection.prepareStatement("select * from products where code = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                product = new Product(code, name, price, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return product;
    }

    public void DBAddProduct(String name, String price, String quantity){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("insert into products (code, name, price, quantity) values (default, ?, ?, ?)");
            statement.setString(1, name);
            statement.setDouble(2, Double.parseDouble(price));
            statement.setInt(3, Integer.parseInt(quantity));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean DBRemoveProduct(String code){
        int action = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("delete from products where code = ?");
            statement.setInt(1, Integer.parseInt(code));
            action = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(action > 0) return true;
        return false;
    }

    public boolean DBEditProduct(String code, String name, String price, String quantity){
        int action = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("update products set name = ?, price = ?, quantity = ?" +
                                                        " where code = ?");
            statement.setString(1, name);
            statement.setDouble(2, Double.parseDouble(price));
            statement.setInt(3, Integer.parseInt(quantity));
            statement.setInt(4, Integer.parseInt(code));
            action = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(action > 0)return true;
        return false;
    }

    public void DBModifyQuanitity(Product p){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("update products set quantity = ? where code = ?");
            statement.setInt(1, p.getQuantity() -  p.getBuyersquantity());
            statement.setInt(2, Integer.parseInt(p.getCode()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
