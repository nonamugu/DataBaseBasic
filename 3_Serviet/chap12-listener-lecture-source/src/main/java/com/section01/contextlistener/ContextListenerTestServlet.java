package com.section01.contextlistener;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Context Listener Test Servlet");

        ServletContext context = request.getServletContext();

        context.setAttribute("test", "value");

        context.setAttribute("test", "value22");

        context.removeAttribute("test");
    }

}
