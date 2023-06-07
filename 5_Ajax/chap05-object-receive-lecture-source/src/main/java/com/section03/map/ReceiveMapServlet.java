package com.section03.map;

import com.model.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/receive/map")
public class ReceiveMapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO member1 = new MemberDTO("get", "gildong", "hong", 20);
        MemberDTO member2 = new MemberDTO("get", "ggukjung", "lim", 22);
        MemberDTO member3 = new MemberDTO("get", "soonsin", "lee", 25);
        MemberDTO member4 = new MemberDTO("get", "sahmyook", "dae", 27);

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("one", member1);
        memberMap.put("two", member2);
        memberMap.put("three", member3);
        memberMap.put("four", member4);

        Iterator<String> keyIter = memberMap.keySet().iterator();

        System.out.println(memberMap);

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        while(keyIter.hasNext()) {
            String key = keyIter.next();

            sb.append("\"").append(key).append("\":").append(memberMap.get(key));

            if(keyIter.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("}");

        System.out.println(sb);

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(sb.toString());

        out.flush();
        out.close();
    }

}
