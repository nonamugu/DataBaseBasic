package com.section1.exception;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/show404error")
public class Show404ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(404, "Page is NOT FOUND!!!!!!!!!!!!!!!");
    }

}
