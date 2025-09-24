package controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


import models.User;
@WebServlet("/signin.do")
public class SigninServlet extends HttpServlet {   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        String email = request.getParameter("email");
        String password = request.getParameter("password");
                

        // String role = request.getParameter("role");
        User user = new User();
        User result = user.signinUser(email, password);
        if (result != null) {
            request.setAttribute("successMessage", "Login successful.");
            request.setAttribute("user", result);
            request.getSession().setAttribute("user", result);
            System.out.println("User Role: " + result.getRole());

            request.getRequestDispatcher(result.getRole() + "dashboard.html").forward(request, response);

        } else {
            request.setAttribute("errorMessage", "Invalid email or password.");
        }
        // request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
