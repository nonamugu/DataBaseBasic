package com.section02.common;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet("/commons/single")
public class CommonsFileUploadServlet extends HttpServlet {

    private String rootLocation;
    private int maxFileSize;
    private String encodingType;

    @Override
    public void init() throws ServletException{
        ServletContext context = getServletContext();

        rootLocation = context.getInitParameter("upload-location");
        maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
        encodingType = context.getInitParameter("encoding-type");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(request)) {

            System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
            System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
            System.out.println("인코딩 방식 : " + encodingType);

            String fileuploadDirectory = rootLocation + "\\commons";
            File directory = new File(fileuploadDirectory);
            if(!directory.exists()) {
                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

            Map<String, String> parameter = new HashMap<>();
            List<Map<String, String>> fileList = new ArrayList<>();

            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            fileItemFactory.setRepository(new File(fileuploadDirectory));
            fileItemFactory.setSizeThreshold(maxFileSize);

            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> fileItems = fileUpload.parseRequest(request);

                for(FileItem item : fileItems) {
                    System.out.println(item);
                }

                for(int i = 0; i < fileItems.size(); i++) {
                    FileItem item = fileItems.get(i);

                    if(!item.isFormField()) {

                        if(item.getSize() > 0) {

                            String fieldName = item.getFieldName();
                            String originFileName = item.getName();

                            int dot = originFileName.lastIndexOf(".");
                            String ext = originFileName.substring(dot);

                            String randomFileName = UUID.randomUUID().toString().replace(" ", "") + ext;

                            File storeFile = new File(fileuploadDirectory + "\\" + randomFileName);

                            item.write(storeFile);

                            Map<String, String> fileMap = new HashMap<>();
                            fileMap.put("filename", fieldName);
                            fileMap.put("originfilename", originFileName);
                            fileMap.put("savedfilename", randomFileName);
                            fileMap.put("savePath", fileuploadDirectory);

                            fileList.add(fileMap);
                        }

                    } else {
//                        parameter.put(item.getFieldName(), item.getString());
                        parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));

                    }

                }

                System.out.println("parameter = " + parameter);
                System.out.println("fileList = " + fileList);

            } catch (Exception e) {
                int cnt = 0;
                for(int i = 0; i < fileList.size(); i++) {
                    Map<String, String> file = fileList.get(i);

                    File deleteFile = new File(fileuploadDirectory + "\\" + file.get("savedFileName"));
                    boolean isDeleted = deleteFile.delete();

                    if(isDeleted) {
                        cnt++;
                    }

                    if(cnt == fileList.size()) {
                        System.out.println("업로드에 실패한 모든 사진 삭제 완료!");
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
