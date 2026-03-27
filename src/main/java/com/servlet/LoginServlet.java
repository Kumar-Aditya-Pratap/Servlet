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

        PrintWriter out = response.getWriter();

        // UC3: Name Validation
        if(!name.matches("[A-Z][a-zA-Z]{2,}")) {

            out.println("<h3>Invalid Name</h3>");
            out.println("Name must start with a capital letter and have at least 3 characters.");
            return;
        }

        if(name.equals("Admin") && password.equals("1234")) {

            request.setAttribute("user", name);

            request.getRequestDispatcher("LoginSuccess.jsp")
                    .forward(request,response);
        }

        else {

            out.println("<h3>Invalid Login</h3>");
        }
    }
}