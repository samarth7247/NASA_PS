package controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Fetch session if exists
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        response.sendRedirect("index.jsp"); // Redirect to home page after logout
    }
}