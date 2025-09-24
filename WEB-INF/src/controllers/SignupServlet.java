package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

@WebServlet("/signup.do")
public class SignupServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String role = request.getParameter("role");

    User user = new User();
    user.setName(name);
    user.setEmail(email);
    user.setPasswordHash(password); 
    user.setRole(role);
    user.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis())); 

    Boolean result = user.saveUser();

    if (result) {
        response.sendRedirect(role + "dashboard.html");
    } else {
        response.sendRedirect("index.jsp");
    }

    }
}
