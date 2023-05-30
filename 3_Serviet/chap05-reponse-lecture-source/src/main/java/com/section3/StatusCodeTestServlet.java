package com.section3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/status")
public class StatusCodeTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(404, "없는 페이지입니다!!! 경로를 확인하세요!!!!!");
//        response.sendError(500, "개발자가 잘못한 서버 내부 오류");
    }

}
