package com.section02.uses;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class EncodingFilter implements Filter {

    private String encodingType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;

        if("POST".equals(hrequest.getMethod())) {
            request.setCharacterEncoding(encodingType);
            System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding());
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }
}
