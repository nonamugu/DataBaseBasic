package com.section02.uses;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("name = " + name);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 pass01과 일치합니까? : " + passwordEncoder.matches("pass01", password));
        System.out.println("비밀번호가 pass02과 일치합니까? : " + passwordEncoder.matches("pass02", password));

    }
}
