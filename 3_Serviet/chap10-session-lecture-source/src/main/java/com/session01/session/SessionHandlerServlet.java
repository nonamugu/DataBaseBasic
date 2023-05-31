package com.session01.session;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println(firstName);
        System.out.println(lastName);


        HttpSession session = request.getSession();

        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);
        System.out.println("변경 후 session 유지 시간 = " + session.getMaxInactiveInterval());

        System.out.println("[session id] " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        response.sendRedirect("/redirect");
    }
}
