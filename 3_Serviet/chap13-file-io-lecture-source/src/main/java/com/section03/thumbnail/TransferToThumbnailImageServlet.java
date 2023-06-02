package com.section03.thumbnail;

import net.coobird.thumbnailator.Thumbnails;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/transferToThumbnail")
public class TransferToThumbnailImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[Server Path] : " + request.getSession().getServletContext().getRealPath("/WEB-INF/"));

        String originFilePath = "C:\\github\\univ_repo\\3_Serviet\\chap13-file-io-lecture-source\\src\\main\\webapp\\resources\\origin-image\\mybatis.PNG";
        File originFile = new File(originFilePath);

        String savePath = "C:\\github\\univ_repo\\3_Serviet\\chap13-file-io-lecture-source\\src\\main\\webapp\\resources\\thumbnail-image\\";
        File thumbFilePath = new File(savePath);
        if(!thumbFilePath.exists()) {
            thumbFilePath.mkdirs();
        }



        String thumbFileName = "mybatis_thumbnail.jpg";

        Thumbnails.of(originFile)
                .size(100, 100)
                .toFile(savePath + thumbFileName);

        System.out.println("[SAVE PATH] thumbFile : " + (thumbFilePath + thumbFileName));
        System.out.println("Thumbnail 변환 성공~!");
    }

}
