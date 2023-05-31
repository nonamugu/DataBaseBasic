package com.section01.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstFilterTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("servlet 요청 확인");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>filter 확인용 servlet 확인 완료!</h3>");
        out.println("</body>");
        out.println("</html>");
    }

}
