package controller;

import entityClasses.Product;
import entityClasses.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "mycart")
public class mycart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Product product = new Product();
        ShoppingCart items = new ShoppingCart();
        items.copyItems((ArrayList<Product>) session.getAttribute("sessionProducts"));
        session.removeAttribute("sessionProducts");
        String code = request.getParameter("code");

        if(items!=null){
            items.addProduct(product.productById(code));
            request.setAttribute("listofproducts", items.getCart());
            session.setAttribute("sessionProducts", items.getCart());
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
        else{
            session.setAttribute("sessionProducts", product.productById(code));
            request.setAttribute("listofproducts", product.productById(code));
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
