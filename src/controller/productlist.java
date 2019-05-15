package controller;

import entityClasses.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productlist")
public class productlist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        HttpSession session = request.getSession(false);
        List<Product> products = product.listOfProduct();
        if (products != null){
            request.setAttribute("products", products);
            request.getRequestDispatcher("/productlist.jsp").forward(request, response);
        }
        else{
            request.setAttribute("errorProducts", "No products found");
            request.getRequestDispatcher("/productlist.jsp").forward(request, response);
        }

    }
}
