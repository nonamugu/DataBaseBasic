package com.section01.contextlistener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    public ContextListenerTest() {
        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destory");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("context Attribute ADD");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("context Attribute REPLACE");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("context Attribute REMOVE");
    }
}
