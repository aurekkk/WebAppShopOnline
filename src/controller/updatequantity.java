package controller;

import entityClasses.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "updatequantity")
public class updatequantity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Product> list = (List<Product>) session.getAttribute("sessionProducts");
        int index = isExisting(request.getParameter("code"), list);
        int buyersquantity = list.get(index).getBuyersquantity();
        if(Integer.parseInt(request.getParameter("newquantity")) > list.get(index).getQuantity()){
            request.setAttribute("toomany", "Out of stock for that many items of " + list.get(index).getName());
        }
        else{
            list.get(index).setBuyersquantity(Integer.parseInt(request.getParameter("newquantity")));
        }
        session.removeAttribute("sessionProducts");
        session.setAttribute("sessionProducts", list);
        request.setAttribute("listofproducts", list);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private int isExisting(String id, List<Product> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getCode().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
