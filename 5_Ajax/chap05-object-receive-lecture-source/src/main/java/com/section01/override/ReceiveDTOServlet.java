package com.section01.override;

import com.model.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/receive/override")
public class ReceiveDTOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO member = new MemberDTO("get", "gildong", "hong", 20);

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(member);

        out.flush();
        out.close();
    }

}
