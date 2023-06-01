package com.section02.sessionlistener;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("발급받은 Session ID : " + session.getId());

        session.setAttribute("username", "홍길동");
        session.setAttribute("age", "300");
        session.setAttribute("gender", "M");

        session.setAttribute("user", new UserDTO("myName", 24));

        session.setAttribute("username", "honggildong");

        session.removeAttribute("gender");

        session.invalidate();
    }

}
