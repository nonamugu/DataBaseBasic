package com.section1.response;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 Servlet Response</h1>\n")
                .append("</body>\n")
                .append("</html>\n");

//        response.setContentType("text/html; charset=UTF-8;");
        System.out.println("default response type : " + response.getContentType());
        response.setContentType("text/html");

        System.out.println("default response encoing : " + response.getCharacterEncoding());
        response.setCharacterEncoding("UTF-8");



        PrintWriter out = response.getWriter();

        out.print(responseBuilder);

        out.flush();

        out.close();
    }

}
