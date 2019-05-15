package controller;

import entityClasses.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= new User();
        if(user.registerUser(request.getParameter("username"), request.getParameter("password"))){
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("password", request.getParameter("password"));
            request.getRequestDispatcher("/login").forward(request, response);
        }
        else{
            request.setAttribute("errorRegister", "Something went wrong. Try again!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
