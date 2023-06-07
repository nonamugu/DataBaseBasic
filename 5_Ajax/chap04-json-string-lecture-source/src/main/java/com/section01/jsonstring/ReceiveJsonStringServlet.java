package com.section01.jsonstring;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/receive/json")
public class ReceiveJsonStringServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20}");

        out.flush();
        out.close();
    }

}
