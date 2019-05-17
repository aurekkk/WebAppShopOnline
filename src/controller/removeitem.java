package controller;

import entityClasses.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "removeitem")
public class removeitem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     HttpSession session = request.getSession(false);
     Product product = new Product();
     if(product.removeProduct(request.getParameter("code"))){
         request.setAttribute("delete", "Product was deleted");
         request.getRequestDispatcher("/removeproduct.jsp").forward(request, response);
     }else{
         request.setAttribute("delete", "No product found with Id:" + request.getParameter("code"));
         request.getRequestDispatcher("/removeproduct.jsp").forward(request, response);
     }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
