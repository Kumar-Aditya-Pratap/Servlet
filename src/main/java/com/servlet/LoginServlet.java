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
            out.println("Name must start with a capital letter and contain at least 3 characters.");
            return;
        }

        // UC4: Password Validation
        if(!password.matches("^(?=.*[A-Z])(?=.*\\d)(?=[^@#$%^&*!]*[@#$%^&*!][^@#$%^&*!]*$).{8,}$")) {

            out.println("<h3>Invalid Password</h3>");
            out.println("Password must contain:");
            out.println("<br>Minimum 8 characters");
            out.println("<br>At least 1 uppercase letter");
            out.println("<br>At least 1 number");
            out.println("<br>Exactly 1 special character");
            return;
        }

        // Login Check
        if(name.equals("Admin") && password.equals("Admin@123")) {

            request.setAttribute("user", name);

            request.getRequestDispatcher("LoginSuccess.jsp")
                    .forward(request,response);
        }

        else {

            out.println("<h3>Invalid Login</h3>");
        }
    }
}