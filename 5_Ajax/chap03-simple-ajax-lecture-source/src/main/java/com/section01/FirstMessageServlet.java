package com.section01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first/message")
public class FirstMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");

        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("message GET!" + message);

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");

        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("message POST!" + message);

        out.flush();
        out.close();
    }
}
