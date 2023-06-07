package com.section02.array;

import com.model.dto.MemberDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/receive/array")
public class ReceiveJsonArrayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO member1 = new MemberDTO("M01", "길동", "홍", 20);
        MemberDTO member2 = new MemberDTO("M02", "꺽정", "임", 22);
        MemberDTO member3 = new MemberDTO("M03", "순신", "이", 25);
        MemberDTO member4 = new MemberDTO("M04", "삼육", "대", 27);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);

        JSONArray jsonArray = new JSONArray();
        for(MemberDTO member : memberList) {
            JSONObject json = new JSONObject();
            json.put("code", member.getCode());
            json.put("firstName", member.getFirstName());
            json.put("lastName", member.getLastName());
            json.put("age", member.getAge());

            jsonArray.add(json);
        }

        System.out.println(jsonArray.toJSONString());

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(jsonArray);

        out.flush();
        out.close();

    }

}
