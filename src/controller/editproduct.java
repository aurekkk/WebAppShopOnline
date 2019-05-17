package controller;

import entityClasses.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "editproduct")
public class editproduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Product product = new Product();
        if(product.editProduct(request.getParameter("code"), request.getParameter("name"), request.getParameter("price"), request.getParameter("quantity"))){
            request.setAttribute("edit", "Product was edited");
            request.getRequestDispatcher("/editproduct.jsp").forward(request, response);
        }
        else{
            request.setAttribute("edit", "No product found with this id " + request.getParameter("code"));
            request.getRequestDispatcher("/editproduct.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
