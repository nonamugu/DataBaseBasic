package com.section01.simple;

import com.model.dto.MemberDTO;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;

@WebServlet("/receive/simple")
public class ReceiveSimpleJsonObjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO member = new MemberDTO("M01", "gildong", "hong", 20);

        JSONObject json = new JSONObject();
        json.put("code", member.getCode());
        json.put("firstName", member.getFirstName());
        json.put("lastName", member.getLastName());
        json.put("age", member.getAge());

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(json);

        out.flush();
        out.close();

    }

}
