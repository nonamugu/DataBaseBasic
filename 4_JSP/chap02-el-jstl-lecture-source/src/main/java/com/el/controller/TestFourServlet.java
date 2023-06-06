package com.el.controller;

import com.el.model.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO sessionMember = new MemberDTO("홍길동", 19, "010-0000-0000", "hgd@sahmyook.com");
        MemberDTO requestMember = new MemberDTO("임꺽정", 20, "010-9999-9999", "igj@sahmyook.com");

        HttpSession session = request.getSession();

        request.setAttribute("member", requestMember);
        session.setAttribute("member", sessionMember);

        RequestDispatcher view = request.getRequestDispatcher("view/el/testEl4.jsp");
        view.forward(request, response);
    }

}
