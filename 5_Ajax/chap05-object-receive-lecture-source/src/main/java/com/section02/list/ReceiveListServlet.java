package com.section02.list;

import com.model.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/receive/list")
public class ReceiveListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO member1 = new MemberDTO("get", "gildong", "hong", 20);
        MemberDTO member2 = new MemberDTO("get", "ggukjung", "lim", 22);
        MemberDTO member3 = new MemberDTO("get", "soonsin", "lee", 25);
        MemberDTO member4 = new MemberDTO("get", "sahmyook", "dae", 27);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);

        System.out.println(memberList);

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(memberList);

        out.flush();
        out.close();

    }

}
