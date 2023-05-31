package com.section1.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /*
        * < 쿠키 사용 방법 >
        * 1. request에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다.
        * 2. 쿠키의 getName과 getValue를 이용해 쿠키에 담긴 값을 사용한다.
        * */
        Cookie[] cookies = request.getCookies();

        for(int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie} " + cookies[i].getName() + " : " + cookies[i].getValue());

            if("fisrtNam".equals(cookies[i].getName())) {
                firstName = cookies[i].getValue();
            } else if("lastName".equals(cookies[i].getName())) {
                lastName = cookies[i].getValue();
            }
        }

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>Your first name is \n")
                .append(firstName)
                .append(" and your last name is \n")
                .append(lastName)
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseText.toString());

        out.flush();
        out.close();
    }
}
