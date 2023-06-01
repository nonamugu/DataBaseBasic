package com.section03.requestlistener;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("username", "홍길동");
        request.setAttribute("age", "300");
        request.setAttribute("gender", "M");

        request.setAttribute("username", "honggildong");

        request.removeAttribute("gender");

    }

}
