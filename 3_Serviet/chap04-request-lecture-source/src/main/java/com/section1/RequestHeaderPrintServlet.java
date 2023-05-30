package com.section1;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

public class RequestHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        System.out.println(request.getHeader("host"));
        System.out.println(request.getHeader("connection"));
        System.out.println(request.getHeader("sec-ch-ua"));
        System.out.println(request.getHeader("sec-ch-ua-mobile"));
        System.out.println(request.getHeader("sec-ch-ua-platform"));
        System.out.println(request.getHeader("upgrade-insecure-requests"));
        System.out.println(request.getHeader("user-agent"));
        System.out.println(request.getHeader("accept"));
        System.out.println(request.getHeader("sec-fetch-site"));
        System.out.println(request.getHeader("sec-fetch-mode"));
        System.out.println(request.getHeader("sec-fetch-user"));
        System.out.println(request.getHeader("sec-fetch-dest"));
        System.out.println(request.getHeader("referer"));
        System.out.println(request.getHeader("accept-encoding"));
        System.out.println(request.getHeader("accept-language"));
        System.out.println(request.getHeader("cookie"));
    }

}
