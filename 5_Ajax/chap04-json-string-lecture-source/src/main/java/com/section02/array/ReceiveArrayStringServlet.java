package com.section02.array;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/receive/array")
public class ReceiveArrayStringServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("[{\"type\":\"get\",\"firstname\":\"gildong\",\"lastname\":\"hong\",\"age\":20},"
                    + "{\"type\":\"get\",\"firstname\":\"ggukjung\",\"lastname\":\"lim\",\"age\":22},"
                    + "{\"type\":\"get\",\"firstname\":\"soonsin\",\"lastname\":\"lee\",\"age\":25},"
                    + "{\"type\":\"get\",\"firstname\":\"sahmyook\",\"lastname\":\"dae\",\"age\":27}]");

        out.flush();
        out.close();

    }

}
