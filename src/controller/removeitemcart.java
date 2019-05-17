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

@WebServlet(name = "removeitemcart")
public class removeitemcart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Product> list = (List<Product>) session.getAttribute("sessionProducts");
        int index = isExisting(request.getParameter("code"), list);
        list.remove(index);
        session.removeAttribute("sessionsProducts");
        session.setAttribute("sessionProducts", list);
        request.setAttribute("listofproducts", list);
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private int isExisting(String id, List<Product> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getCode().equals(id)){
                return i;
            }
        }
        return -1;
    }

}
