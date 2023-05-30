package com.section1.queryString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);

        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(age);

        java.sql.Date birthDay = java.sql.Date.valueOf(request.getParameter("birthday"));
        System.out.println(birthDay);

        String gender = request.getParameter("gender");
        System.out.println(gender);

        String national = request.getParameter("national");
        System.out.println(national);

        System.out.println("취미 : ");
        String[] hobbies = request.getParameterValues("hobbies");
        for(String hobby : hobbies) {
            System.out.println(hobby);
        }
    }

}
