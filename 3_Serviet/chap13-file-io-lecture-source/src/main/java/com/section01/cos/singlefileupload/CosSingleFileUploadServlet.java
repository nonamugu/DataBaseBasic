package com.section01.cos.singlefileupload;

import com.common.UUIDFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/cos/single")
public class CosSingleFileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(request)) {

            ServletContext context = request.getServletContext();
            String rootlocation = context.getInitParameter("upload-location");
            int maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
            String encodingType = context.getInitParameter("encoding-type");

            System.out.println("파일 저장 ROOT 경로 : " + rootlocation);
            System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
            System.out.println("인코딩 방식 : " + encodingType);

            String singleFileUploadDirectory = rootlocation + "\\cos\\single";

            File directory = new File(singleFileUploadDirectory);

            if(!directory.exists()) {
                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

//            MultipartRequest multipartRequest = new MultipartRequest(request, singleFileUploadDirectory,
//                                                                    maxFileSize, encodingType, new DefaultFileRenamePolicy());

            MultipartRequest multipartRequest = new MultipartRequest(request, singleFileUploadDirectory,
                                                                    maxFileSize, encodingType, new UUIDFileRenamePolicy());

            String description = multipartRequest.getParameter("description");
            System.out.println("description = " + description);

            Enumeration<String> names = multipartRequest.getFileNames();
            while(names.hasMoreElements()) {
                System.out.println(names.nextElement());
            }

            String originFileName = multipartRequest.getOriginalFileName("singlefile");
            System.out.println("form 전송된 파일의 원본 이름 : " + originFileName);

            String changedFileName = multipartRequest.getFilesystemName("singlefile");
            System.out.println("파일 시스템에 저장된 변경된 파일명 : " + changedFileName);

            String filePath = singleFileUploadDirectory;

            File remover = new File(singleFileUploadDirectory + "\\" + changedFileName);
            System.out.println("파일 삭제를 성공했습니까? " + remover.delete());

        }
    }

}
