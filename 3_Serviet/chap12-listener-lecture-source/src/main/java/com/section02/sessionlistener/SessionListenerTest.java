package com.section02.sessionlistener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    public void SessionListenerTest() {
        System.out.println("session listener 인스턴스 생성");
    }

    public void sessionCreated(HttpSessionEvent hse) {
        System.out.println("session CREATE");
    }

    public void sessionDestroyed(HttpSessionEvent hse) {
        System.out.println("session DESTORY");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        System.out.println("session Attribute ADD");
        System.out.println("session에 추가한 attr : " + hsbe.getName() + " : " + hsbe.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {
        System.out.println("session Attribute REPLACE");
        System.out.println("session에 수정한 attr : " + hsbe.getName() + " : " + hsbe.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent hsbe) {
        System.out.println("session Attribute REMOVE");
        System.out.println("session에서 삭제한 attr : " + hsbe.getName() + " : " + hsbe.getValue());

    }
}
