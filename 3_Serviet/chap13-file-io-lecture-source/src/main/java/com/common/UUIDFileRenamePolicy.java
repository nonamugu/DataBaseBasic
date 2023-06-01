package com.common;

import com.oreilly.servlet.multipart.FileRenamePolicy;

import java.io.File;
import java.util.UUID;

public class UUIDFileRenamePolicy implements FileRenamePolicy {

    @Override
    public File rename(File file) {

        String fileName = file.getName();
        int dot = fileName.lastIndexOf(".");
        String body = fileName.substring(8, dot);
        String ext = fileName.substring(dot);

        String fileId = UUID.randomUUID().toString().replace(" ", "");

        System.out.println("기존 파일 명 : " + fileName);
        System.out.println("body = " + body);
        System.out.println("ext = " + ext);
        System.out.println("변경된 파일명 : " + fileId);

        return new File(file.getParent(), fileId + ext);
    }
}
