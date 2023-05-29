package com.section2.annotaion;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet() { }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation mapping init() method 호출 : " + initCount++);
    }

    public void destroy() {
        System.out.println("annotation mapping destroy() method 호출 : " + destroyCount++);
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("annotation mapping service() method 호출 : " + serviceCount++);
    }

}
