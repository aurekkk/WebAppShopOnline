package controller;

import entityClasses.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        if(user.isValidLogin(request.getParameter("username"), request.getParameter("password"))){
            HttpSession session = request.getSession();
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("password", request.getParameter("password"));
            session.setAttribute("user", request.getParameter("username"));
            session.setAttribute("role", user.userRole(request.getParameter("username")));
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "Invalid username or password. Please try again!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
