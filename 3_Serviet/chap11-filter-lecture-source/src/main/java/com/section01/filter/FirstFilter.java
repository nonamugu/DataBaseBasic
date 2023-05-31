package com.section01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/first/*")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter doFilter 호출");

        /* doFilter 수행할 코드 */

        chain.doFilter(request, response);

        System.out.println("Servlet 요청 수행 완료");

    }

    @Override
    public void destroy() {
        System.out.println("Filter destory");
    }
}
