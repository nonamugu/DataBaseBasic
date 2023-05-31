package com.section1.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /*
         * < 쿠키 사용일자 >
         * 1. 쿠키를 생성한다.
         * 2. 생성한 쿠키의 만료 시간을 설정한다.
         * 3. 응답 헤더에 쿠키를 담는다.
         * 4. 응답을 보낸다.
         *
         * < 쿠키 이름 설정 시 제약사항 >
         * 1. 쿠키 이름은 ASCII 문자만을 사용해야 하며 한번 설정한 후 변경 불가
         * 2. 쿠키의 이름에는 공백문자와 일부 특수문자([ ] ( ) = ,  " \ ?  @ : ;)를 사용 불가
         * 3.
         * */
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        firstNameCookie.setMaxAge(60 * 60 * 24);
        lastNameCookie.setMaxAge(60 * 60 * 24);

        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);

        response.sendRedirect("redirect");

    }
}