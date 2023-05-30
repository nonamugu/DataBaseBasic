package com.section2.formdata;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getCharacterEncoding());

        request.setCharacterEncoding("UTF-8");

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

        Map<String, String[]> resultMap = request.getParameterMap();
        Set<String> ketSet = resultMap.keySet();
        Iterator<String> keyIter = ketSet.iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            String[] value = resultMap.get(key);
            System.out.println("key = " + key);
            for(int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        }

        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }



    }
}
