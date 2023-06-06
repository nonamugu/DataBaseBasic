package com.section01;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/javascript")
public class JavascriptAjaxTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        String output = name + "님 환영합니다!";

        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(output);

        out.flush();
        out.close();
    }

}
