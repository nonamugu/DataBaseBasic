package com.section1.forward;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forward")
public class ReceivenInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        System.out.println(userId);
        System.out.println(password);

        /*
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>>" + userId + "님 환영합니다~!!!! </h3>\n")
                .append("</body>\n")
                .append("</html>\n");

        PrintWriter out = response.getWriter();
        out.println(responseText.toString());
        out.flush();
        out.close();
        */

        request.setAttribute("userId", userId);

        RequestDispatcher rd = request.getRequestDispatcher("print");
        rd.forward(request, response);


    }
}
