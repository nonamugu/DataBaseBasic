package com.section02.uses;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        RequestWrapper wrapper = new RequestWrapper(hrequest);

        chain.doFilter(wrapper, response);

    }

    @Override
    public void destroy() { }

}