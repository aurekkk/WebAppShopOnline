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

@WebServlet(name = "buyproducts")
public class buyproducts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Product product = new Product();
        String name = request.getParameter("name"); request.setAttribute("oname", name);
        String address = request.getParameter("address");request.setAttribute("oaddress", address);
        String email = request.getParameter("email");request.setAttribute("oemail", email);
        String mobile = request.getParameter("mobile");request.setAttribute("omobile", mobile);
        List<Product> list = (List<Product>) session.getAttribute("sessionProducts");
        for (int i = 0; i<list.size(); i++){
            product.modifyQuantity(list.get(i));
        }
        session.removeAttribute("sessionProduct");
        request.setAttribute("ototal", request.getParameter("total"));
        request.removeAttribute("listofproducts");
        request.setAttribute("order", "Thank you! Products are on their way to your house!");
        request.getRequestDispatcher("/buyproducts.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void modifyQuanitity(Product p){
        int quantity = p.getQuantity();
        int orderedquantity = p.getBuyersquantity();
        p.setQuantity(quantity - orderedquantity);
    }
}
