package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        if(name.equals("Admin") && password.equals("1234")) {

            request.setAttribute("user", name);

            request.getRequestDispatcher("LoginSuccess.jsp")
                    .forward(request,response);
        }

        else {

            PrintWriter out = response.getWriter();
            out.println("<h3>Invalid Login</h3>");
        }
    }
}