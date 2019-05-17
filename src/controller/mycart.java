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
        Product product=new Product();
        String code = request.getParameter("code");
        List<Product> list = (List<Product>) session.getAttribute("sessionProducts");
        if(code != null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            if(isExisting(code, list)!= -1){
                int index = isExisting(code, list);
                int buyersquantity = list.get(index).getBuyersquantity();
                if((buyersquantity+1) > list.get(index).getQuantity()){
                    request.setAttribute("toomany", "Out of stock for that many items of " + list.get(index).getName());
                }
                else{
                    list.get(index).setBuyersquantity(buyersquantity + 1);
                }
                session.removeAttribute("sessionProducts");
                session.setAttribute("sessionProducts", list);
                request.setAttribute("listofproducts", list);
                request.getRequestDispatcher("/cart.jsp").forward(request, response);

            }
            else {
                list.add(product.productById(code));
                session.removeAttribute("sessionProducts");
                session.setAttribute("sessionProducts", list);
                request.setAttribute("listofproducts", list);
                request.getRequestDispatcher("/cart.jsp").forward(request, response);
            }
        }
        else{
            request.setAttribute("listofproducts", list);
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private int isExisting(String id, List<Product> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getCode().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
}
