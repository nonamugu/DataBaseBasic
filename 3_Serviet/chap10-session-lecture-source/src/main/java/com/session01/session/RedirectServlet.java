package com.session01.session;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("redirect firstName = " + firstName);
        System.out.println("redirect lastName = " + lastName);

        HttpSession session = request.getSession();
        System.out.println("[redirect된 Session id] " + session.getId());

        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        firstName = (String) session.getAttribute("firstName");
        lastName = (String) session.getAttribute("lastName");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!doctype html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Session을 이용해 받아온 당신의 firstName은 " + firstName + "이고, lastName은 " + lastName + "입니다.</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();

    }

}