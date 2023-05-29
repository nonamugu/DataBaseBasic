package com.section1.xml;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {

    public int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet() { }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml mapping init() method 호출 : " + initCount++);
    }

    public void destroy() {
        System.out.println("xml mapping destroy() method 호출 : " + destroyCount++);
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("xml mapping service() method 호출 : " + serviceCount++);
    }

}
